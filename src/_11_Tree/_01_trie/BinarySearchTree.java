package _11_Tree._01_trie;

import java.util.List;
import java.util.function.Consumer;

//二叉搜索树
// 自平衡二叉查找树
public class BinarySearchTree<K, V> implements IBinarySearchTree<K, V> {

    private Node<K, V> root;

    protected class Node<K, V> {
        public K key;
        public V value;
        public Node<K, V> left;
        public Node<K, V> right;
        public Node<K, V> parent;
        public boolean isLeftChild;//要么 左孩子要么右孩子
        public int height;//高度
        public int num;//编号

        public Node() {

        }

        public Node(K key, V value, Node<K, V> left, Node<K, V> right, Node<K, V> parent) {
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

        @Override
        public String toString() {
            return "Node [key=" + key + ']';
        }
    }

    @Override
    public Node<K, V> insert(K key, V value) {
        //key 可被比较
        if (!(key instanceof Comparable)) {
            throw new ClassCastException();
        }
        Node<K, V> p = null;
        Node<K, V> curr = root;//root 可能有问题 find 全局
        while (curr != null) {
            p = curr;
            if(compare(key,curr.key)<0){
                curr=curr.left;
            }else if()
        }
        return null;
    }

    private int compare(K key, K key1) {
    }

    @Override
    public void inOrder(Consumer<K> con) {

    }

    @Override
    public V lookupValue(K key) {
        return null;
    }

    @Override
    public V min() {
        return null;
    }

    @Override
    public V max() {
        return null;
    }

    @Override
    public void remove(K key) {

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
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public List<List<Node<K, V>>> levelOrder() {
        return null;
    }

}
