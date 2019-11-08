package _10_Hash;

public class MyHashMap<K,V> implements IMap<K,V> {

    /**
     * Node节点
     *
     * @param <K>
     * @param <V>
     */
    private class Node<K, V> {
        K key;
        V value;
        Node next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    //创建桶
    int N = 16;
    private Node[] buckets = new Node[N];
    private int size = 0;



    @Override
    public void clear() {
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = null;
        }

    }

    @Override
    public boolean containsKey(K key) {
        int index = hash1(key);
        if (buckets[index] == null)//查看有没有对应的桶
            return false;
        else {
            Node<K, V> p = buckets[index];//在链表中找key
            while (p != null) {
                K k1 = p.key;
                //借用java机制 hashCode和 equals都来源与 Object 用户可以改写这两个方法制定对象相等的原则
                //k1==key 比较的是对象的地址 java 默认 hashCode和equals都是基于对象地址
                if (k1 == key || k1.hashCode() == key.hashCode() && k1.equals(key)) {
                    return true;
                }
                p = p.next;
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] != null) {
                Node<K, V> p = buckets[i];
                while (p != null) {
                    if (p.value.equals(value))
                        return true;
                    p = p.next;
                }
            }

        }
        return false;
    }

    @Override
    public V get(K key) {
        int index = hash1(key);//先看看有没有这个key的桶
        if (buckets[index] == null) {
            return null;
        } else {
            Node<K, V> p = buckets[index];
            while (p != null) {
                K k1 = p.key;
                if (k1 == key || k1.equals(key) && k1.hashCode() == key.hashCode()) {
                    return p.value;
                }
                p = p.next;
            }
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public K[] keySet() {
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] != null) {
                Node<K, V> p = buckets[i];
                while (p != null) {
                    sb.append("(" + p.key + "," + p.value + ")" + ",");
                    p = p.next;
                }
            }
        }
        return sb.toString();
    }

    /**
     * 解决冲突的时候使用拉链法
     * 相同替换 不同就追加
     * @param key
     * @param value
     */
    @Override
    public void put(K key, V value) {
        Node<K, V> node = new Node<>(key, value);
        int index = hash1(key);//算出在桶中的位置
        if (buckets[index] == null) {//桶子中没有东西 确定链表的表头
            buckets[index] = node;
            size++;
        } else {
            Node<K, V> p = buckets[index];//链表的表头找到
            while (p != null) {//遍历链表 从头开始
                K k1 = p.key;
                if (key == k1 || key.hashCode() == k1.hashCode() && key.equals(k1)) {//存在key相同就覆盖
                    p.value = value;//存在相同的key 则更新value
                    break;
                }
                if (p.next == null) {//最后一个
                    p.next = node;
                    size++;
                    break;
                }
                p = p.next;// 没有 相同key  也不是最后一个 指针后移
            }

        }

    }

    /**
     * 算出在桶中的位置
     *
     * @param key
     * @return
     */
    private int hash1(K key) {
        return key.hashCode() % N;
    }

    @Override
    public void putAll(IMap<? extends K, ? extends V> map) {

    }

    @Override
    public V remove(K key) {
        int index = hash1(key);
        if (buckets[index] == null) {
            return null;
        } else {
            //单向链表移除某个节点需要两个指针
            Node<K, V> p = buckets[index];//表头
            Node<K, V> pre = p;
            while (p != null) {
                K k1 = p.key;
                if (k1 == key || k1.hashCode() == key.hashCode() && k1.equals(key)) {
                    //匹配到了移除
                    if (p == pre) {//是头结点
                        buckets[index] = pre.next;//buckets[index]相当于单链表的first
                    } else {
                        pre.next = p.next;//原本 pre.next==p
                    }
                    return p.value;
                }
                pre = p;
                p = p.next;
            }
        }

        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public V[] values() {
        return null;
    }
}
