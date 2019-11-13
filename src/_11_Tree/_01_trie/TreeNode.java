package _11_Tree._01_trie;

import java.util.List;

public class TreeNode<E> {
    public E key;//data
    public TreeNode<E> parent;
    public List<TreeNode<E>> children;

    /**
     * 初始化它的key和 定义父节点
     *
     * @param key
     * @param parent
     */
    public TreeNode(E key, TreeNode<E> parent) {
        this.key = key;
        this.parent = parent;
    }

    public TreeNode(E key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "TreeNode[" + "key=" + key + ']';
    }
}
