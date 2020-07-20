package _11_Tree._01_trie;

public class BSTNode<K, V> {
    public K key;
    public V value;
    public BSTNode<K, V> left;
    public BSTNode<K, V> right;
    public BSTNode<K, V> parent;
    public Boolean isLeftChild;
    public int height;//以这个节点的根的高度
    public int num;//编号

    public BSTNode() {

    }

    public BSTNode(K key, V value, BSTNode<K, V> left, BSTNode<K, V> right, BSTNode<K, V> parent) {
        super();
        this.key = key;
        this.value = value;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }

    public boolean isLeft() {
        return isLeftChild;
    }

    public boolean isRight() {
        return !isLeftChild;
    }

}

