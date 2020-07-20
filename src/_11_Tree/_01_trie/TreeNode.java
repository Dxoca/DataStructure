package _11_Tree._01_trie;

import java.util.List;

public class TreeNode<E> {
    public E key;//data //数据
    public TreeNode<E> parent;// 父节点
    public List<TreeNode<E>> children;//子节点 可以看成一个链表

    /**
     * 初始化它的key和 定义(指向父亲)父节点
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
