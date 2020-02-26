package _11_Tree._01_trie;

public class BinarySearchTree<K, V> {

    protected class Node<K, V> {
        public K key;
        public V value;
        public Node<K, V> left;
        public Node<K, V> right;
        public Node<K, V> parent;
        public boolean isLeftChild;
        public int height;
        public int num;

        public Node() {

        }

        public Node(K key, V value, Node<K, V> left, Node<K, V> right, Node<K, V> parent) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }
    }
}
