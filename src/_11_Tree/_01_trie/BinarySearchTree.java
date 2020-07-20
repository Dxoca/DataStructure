package _11_Tree._01_trie;
//https://github.com/Dxoca/Algorithm_LanQiao/blob/master/src/main/java/org/lanqiao/algo/elementary/_11_tree/BinarySearchTree.java

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class BinarySearchTree<K, V> implements IBinarySearchTree<K, V> {
    /**
     * 根节点
     */
    protected BSTNode root;
    /**
     * 元素个数
     */
    protected int size;

    BinarySearchTree() {
    }

    /**
     * 更新节点高度
     *
     * @param curr
     */
    private void updateHeight(BSTNode<K, V> curr) {
        if (curr.parent == null) return;//util root
        BSTNode<K, V> p = curr.parent;//update this node be father
        if (p.height == curr.height) {
            p.height++;
            updateHeight(p);//递归
        }
    }

    /**
     * 插入节点
     * 用到 Comparable 接口
     *
     * @param key
     * @param value
     * @return
     */
    @Override
    public BSTNode<K, V> insert(K key, V value) {
        if (!(key instanceof Comparable)) {//判断是否可比较 不能比较就不能创建
            throw new ClassCastException();
        }
        BSTNode<K, V> parent = null;
        BSTNode<K, V> curr = root;//current 和parent 是父子关系
        //找到要插入的位置
        while (curr != null) {
            parent = curr;//记录插入位置的父节点
            if (compare(key, curr.key) < 0)
                curr = curr.left;//小的在左边
            else if (compare(key, curr.key) > 0) {
                curr = curr.right;
            } else { //相同 无法插入
                curr.value = value;
                return curr;
            }
        }
        //Link new Node  with key,value,parent.
        curr = new BSTNode(key, value, null, null, parent);
        if (parent == null) {//父节点没有 说明是插入第一个元素 就是根节点
            root = curr;
        } else if (compare(key, parent.key) < 0) {
            parent.left = curr;
            curr.isLeftChild = true;
        } else {
            parent.right = curr;
            curr.isLeftChild = false;
        }

        size++;//节点数目
        updateHeight(curr);//更新树的高度
        return curr;
    }

    /**
     * 中序遍历
     * Consumer义定一个参数,对其进行(消费)处理,处理的方式可以是任意操作.
     *
     * @param con
     */
    @Override
    public void inOrder(Consumer<K> con) {
        if (root != null)
            inOrder(root, con);
    }

    private void inOrder(BSTNode<K, V> p, Consumer<K> con) {
        if (p != null) {
            inOrder(p.left, con);
            con.accept(p.key);
            inOrder(p.right, con);
        }
    }

    /**
     * 通过 key查 value
     * O(n)~O([LogN+1])
     *
     * @param key
     * @return
     */
    @Override
    public V lookupValue(K key) {
        //查找值 创建值的节点
        BSTNode<K, V> lookupNode = lookupNode(key);
        return lookupNode == null ? null : lookupNode.value;
    }

    private BSTNode<K, V> lookupNode(K key) {
        BSTNode<K, V> p = root;
        //不为空和 没找到
        while (p != null && compare(key, p.key) != 0) {
            if (compare(key, p.key) < 0) {//小了 在左边
                p = p.left;
            } else {
                p = p.right;
            }
        }
        return p;
    }

    @Override
    public K min() {
        return minNode(root).key;
    }

    private BSTNode<K, V> minNode(BSTNode p) {
        while (p.left != null) {
            p = p.left;
        }
        return p;
    }

    @Override
    public K max() {
        return maxNode(root).key;
    }

    private BSTNode<K, V> maxNode(BSTNode p) {
        while (p.right != null)
            p = p.right;
        return p;
    }

    /**
     * 找到对应的key节点
     *
     * @param key 通过k删除节点
     */
    @Override
    public void remove(K key) {
        removeNode(lookupNode(key));//查找删除的节点
        size--;

    }

    /**
     * 11.10BST中移除节点
     * 有三种情况：
     * 1.叶子 Leaf Node :最边界的节点 无子节点 ：断相互连接就好
     * 2.单支（左/右）： 顶替即可
     * 3.双支 ：找 右子树的最小节点min ，并把数据替换进去。删除min（右侧最小min替代x 删min）
     *
     * @param x
     */
    private void removeNode(BSTNode<K, V> x) {
        if (x != null) {//节点存在
            if (x.left == null && x.right == null) {//为leaf node 就是无子节点 最边界
                if (x.parent == null) {//根节点
                    root = null;
                    return;
                }
                if (x.isLeftChild) {//父亲指向子节点 断开
                    x.parent.left = null;
                } else {
                    x.parent.right = null;
                }
                x.parent = null;//子节点指向父亲 断开
//                x = null;
            } else if (x.left == null) {//x只有右节点
                if (x.isLeftChild) {//x是左孩子
                    BSTNode<K, V> c = x.right;//x的右孩子替代他
                    BSTNode<K, V> parent = x.parent;
                    parent.left = c;
                    c.isLeftChild = true;
                    c.parent = parent;
                } else {//x是右孩子
                    if (x.parent != null) {//x有父亲 所以不是根节点 三点一线
                        x.parent.right = x.right; //直接把x换成 他的右子节点 //父亲指向x的右子节点
                        x.right.parent = x.parent;//
                    } else {//x是根节点
                        root = x.right;
                    }
                }
                x = null;//自己位空
            } else if (x.right == null) {//x只有 左节点
                if (x.isLeftChild) { // x是左孩子 三点一线
                    x.parent.left = x.left;
                    x.left.parent = x.parent;
                } else {//x为右边孩子  有左节点
                    if (x.parent != null) {//218 //存在父亲
                        x.parent.right = x.left;
                        x.left.isLeftChild = false;//替换了x 并成为了右节点
                        x.left.parent = x.parent;
                    } else {//无父亲 为根节点
                        root = x.left;
                    }
                }
                x = null;
            } else {//双分支 都存在 不为空
                BSTNode<K, V> minOfRight = minNode(x.right);//找出右边分支最大的来替换
                x.key = minOfRight.key;//替换key 和value 原指向不变。
                x.value = minOfRight.value;
                removeNode(minOfRight);//删除该节点即可（右子树最小元素）
            }
        }
    }

    @Override
    public K successor(K x) {
        return null;
    }

    @Override
    public K predecessor(K x) {
        return null;
    }

    @Override
    public Boolean isBalance() {
        return null;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public int getHeight() {
        return getHeight(root);
    }

    protected int getHeight(BSTNode node) {
//        if (node == null) return 0;
//        int l = getHeight(node.left);
//        int r = getHeight(node.right);
//        return 1 + Math.max(l, r);
        return node.height;
    }

    @Override
    public List<List<BSTNode<K, V>>> levelOrder() {
        return null;
    }

    //Comparator接口 独立的类中实现比较 不强制进行自然排序，可以指定排序顺序。
    private Comparator comparator;

    public BinarySearchTree(Comparator comparator) {
        this.comparator = comparator;
    }

    private int compare(K key, K key1) {
        if (null == comparator)
            return ((Comparable) key).compareTo((Comparable) key1);
        else
            return comparator.compare(key, key1);
    }

}
