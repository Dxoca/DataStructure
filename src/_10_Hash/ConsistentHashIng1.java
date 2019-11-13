package _10_Hash;
//一致性hash

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.*;

/**
 * 起源 关于集群和负载均衡 服务器集群
 */
public class ConsistentHashIng1 {

    //hash算法 将 关键字映射到2^32的环状空间里面
    static long hash(String key) {
        ByteBuffer buf = ByteBuffer.wrap(key.getBytes());
        int seed = 0x1234ABCD;

        ByteOrder byteOrder = buf.order();
        buf.order(ByteOrder.LITTLE_ENDIAN);

        long m = 0xc6a4a7935bd1e995L;
        int r = 47;

        long h = seed ^ (buf.remaining() * m);

        long k;
        while (buf.remaining() >= 8) {
            k = buf.getLong();

            k *= m;
            k ^= k >>> r;
            k *= m;

            h ^= k;
            h *= m;
        }
        if (buf.remaining() > 0) {
            ByteBuffer finish = ByteBuffer.allocate(8).order(
                    ByteOrder.LITTLE_ENDIAN);
            // for big-endian version, do this first:
            // finish.position(8-buf.remaining());
            finish.put(buf).rewind();
            h ^= finish.getLong();
            h *= m;
        }

        h ^= h >>> r;
        h *= m;
        h ^= h >>> r;

        buf.order(byteOrder);
        return Math.abs(h);
    }

    //机器节点==网络节点
    static class Node implements HashNode {
        String name;
        String ip;

        @Override
        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return this.name + "\t" + this.ip;
        }

        public Node(String name, String ip) {
            this.name = name;
            this.ip = ip;
        }

    }

    interface HashNode {
        String getName();
    }

    // 节点列表
    List<Node> nodes;
    TreeMap<Long, Node> hashAndNode = new TreeMap<>();//存hash和节点 节点的hash保存和处理
    TreeMap<Long, Node> keyAndNode = new TreeMap<>();//存key和节点 增加资源

    /**
     * 机器节点初始化
     *
     * @param nodes
     */
    public ConsistentHashIng1(List<Node> nodes) {
        this.nodes = nodes;
        init();//初始化
    }

    private void init() {
        for (int i = 0; i < nodes.size(); i++) {
            Node node = nodes.get(i);
            long hash = hash(node.ip);
            hashAndNode.put(hash, node);
        }
    }

    //增加资源 key User
    private void add(String key) {
        long hash = hash(key);
        SortedMap<Long, Node> subMap = hashAndNode.tailMap(hash);//找到map中key所有fromKey大的 所有的键值对，组成一个子Map
        if (subMap.size() == 0) {//环的尽头 折回到first
            keyAndNode.put(hash, hashAndNode.firstEntry().getValue());
        } else {
            Node node = subMap.get(subMap.firstKey());//第一个节点，key应该归属的节点
            keyAndNode.put(hash, node);
        }
    }

    /**
     * 增加新的机器节点
     * 要特判 插入的节点在环头
     *
     * @param newNode
     */
    private void add(Node newNode) {
        long hash = hash(newNode.ip);
        hashAndNode.put(hash, newNode);
        //数据迁移 模拟 和实际不相符。
        SortedMap<Long, Node> pre = hashAndNode.headMap(hash);//所以小于toKey的hash组成的map
        if (pre.size() == 0) {//新机器节点在环的头部
            //0~这个节点
            SortedMap<Long, Node> between = keyAndNode.subMap(new Long(0), hash);
            for (Map.Entry<Long, Node> entry : between.entrySet()) {//改变这个范围内的映射关系
                entry.setValue(newNode);
            }
            //最后一个节点到 2^32
            between = keyAndNode.tailMap(hashAndNode.lastKey());
            for (Map.Entry<Long, Node> entry : between.entrySet()) {//改变这个范围内的映射关系
                entry.setValue(newNode);
            }
        } else {//在环的非头部
            long from = pre.lastKey();
            long to = hash;
            SortedMap<Long, Node> between = keyAndNode.subMap(from, to);
            for (Map.Entry<Long, Node> entry : between.entrySet()) {//改变这个范围内的映射关系
                entry.setValue(newNode);
            }
        }
    }

    public void remove(Node oldNode) {
        long hash = hash(oldNode.ip);
        if (!hashAndNode.containsKey(hash))//不存在该节点
            return;
        SortedMap<Long, Node> pre = hashAndNode.headMap(hash);//所有 比hash小的Node组成的map
        SortedMap<Long, Node> next = hashAndNode.tailMap(hash);

        int cnt = 0;//取出目标节点的下一个节点
        Node nextNode = hashAndNode.firstEntry().getValue();//第一个节点
        /**
         * 三种情况： 头 中 尾
         * 1.如果是删除最后一个节点 next指向 √
         * 2. 删除头结点 两部分资源分配
         * 3.node 删除 清理
         */
        //返回oldNode的下一个节点
        for (Map.Entry<Long, Node> entry : next.entrySet()) {
            if (cnt++ == 1) {
                nextNode = next.get(entry.getKey());
                break;
            }
        }

        System.out.println("删除：" + oldNode.name);
        System.out.println("迁移：" + nextNode.name);
        if (pre.size() == 0) {//该节点 是最小的节点
            SortedMap<Long, Node> between = keyAndNode.subMap(new Long(0), hash);
            for (Map.Entry<Long, Node> entry : between.entrySet()) {
                entry.setValue(nextNode);
            }
            between = keyAndNode.tailMap(hashAndNode.lastKey());//最后一个节点之后的key
            for (Map.Entry<Long, Node> entry : between.entrySet()) {
                entry.setValue(nextNode);
            }
            System.out.println("要删除的是头结点");
        } else {
            long from = pre.lastKey();
            long to = hash;
            SortedMap<Long, Node> source = keyAndNode.subMap(from, hash);//被节点删的 key(user)数据
            if (source.size() == 0) {//无迁移资源
                System.out.println("无迁移资源");
                return;
            }
            for (Map.Entry<Long, Node> entry : source.entrySet()) {//改变这个范围内的映射关系
                entry.setValue(nextNode);//换Value 到目标节点
            }

        }
        hashAndNode.remove(hash);

    }

    public static void main(String[] args) {
        ArrayList<Node> nodes = new ArrayList<>();
        nodes.add(new Node("node0", "192.168.1.2"));
        nodes.add(new Node("node1", "192.168.1.3"));
        nodes.add(new Node("node2", "192.168.1.4"));
        nodes.add(new Node("node3", "192.168.1.5"));
        nodes.add(new Node("node4", "192.168.1.6"));

        ConsistentHashIng1 obj = new ConsistentHashIng1(nodes);

        // Entry遍历 节点 ：遍历TreeMap的键值对
        obj.traversalNode(obj.hashAndNode);
        //add User资源
        obj.add("zhang.sant");
        obj.add("saf4t2");
        obj.add("sas2gg3rr3t4");
        obj.add("saf2gg3425err5456");
        obj.add("235f2gg34256434636");
        obj.add("saf2gg34256r364y22");
        obj.add("s5f2gg3425634636y22hw3h2hh");
        obj.add("s652gg342563463hry22hw3h2hh36362");
        obj.add("su7tgjg3425634636hhw3h2hh3636245yy4y4");
        obj.add("sadfgg3425634636yjtyz2hh3636245yy4y4gdfsgh45u54");
        obj.add("sa56gg3425634636y22hw3h2hh36245yy4y4asdg3h45u54");
        for (Map.Entry<Long, Node> entry :
                obj.keyAndNode.entrySet()) {
            System.out.println(entry.getValue().getName() + " \t收到资源： \t" + "hash:" + " \t" + entry.getKey());
        }
        //加入新节点
        nodes.add(new Node("node5", "192.168.1.9"));
        obj.add(nodes.get(5));
        System.out.println("=====更新List===");

        obj.traversalNode(obj.hashAndNode);
        obj.traversalUser(obj.keyAndNode);

        System.out.println("=====更新List===");
        obj.remove(nodes.get(0));
        System.out.println("查看删除后的节点User");
        obj.traversalNode(obj.hashAndNode);
        obj.traversalUser(obj.keyAndNode);
        obj.remove(nodes.get(4));
        System.out.println("查看删除后的节点User");
        obj.traversalNode(obj.hashAndNode);
        obj.traversalUser(obj.keyAndNode);
        obj.remove(nodes.get(5));
        System.out.println("查看删除后的节点User");
        obj.traversalNode(obj.hashAndNode);
        obj.traversalUser(obj.keyAndNode);

    }

    private void traversalNode(Map<Long, Node> hashAndNode) {
        // Entry遍历 节点 ：遍历TreeMap的键值对
        for (Map.Entry<Long, Node> entry : hashAndNode.entrySet()) {//升序键序 遍历hashAndNode
            System.out.println(entry.getKey() + ":  \t" + entry.getValue());
        }
    }

    private void traversalUser(Map<Long, Node> keyAndNode) {

        for (Map.Entry<Long, Node> entry :
                keyAndNode.entrySet()) {
            System.out.println(entry.getValue().getName() + " \t收到资源： \t" + "hash:" + " \t" + entry.getKey());
        }
    }
}
