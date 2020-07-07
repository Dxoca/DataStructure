package _11_Tree._01_trie;

import java.util.List;
import java.util.function.Consumer;

//二叉树
public interface IBinarySearchTree<K, V> {

    /**
     * 新增节点
     *
     * @param k 关键字
     * @param v 值
     * @return
     */
    BinarySearchTree<K, V>.Node<K, V> insert(K k, V v);

    /**
     * 中序遍历 处理中序遍历中的每个元素的函数
     *
     * @param con
     */
    void inOrder(Consumer<K> con);

    /**
     * 查找元素
     *
     * @param key
     * @return
     */
    V lookupValue(K key);

    /**
     * 获取最小关键字
     *
     * @return
     */
    V min();

    /**
     * 获取最大关键字
     *
     * @return
     */
    V max();

    /**
     * 移除关键字对应的节点
     *
     * @param key
     */
    void remove(K key);

    /**
     * x的后继-  [比x大的第一个元素]
     * 1、其右边子树的最小值
     * 2、没有子树，则向上追溯，直到每个祖先节点是左孩子，返回这个祖先节点的父亲节点 它就是x的后继
     * 后继：比她大的第一个元素
     *
     * @param x
     * @return
     */
    K successor(K x);

    /**
     * 前驱 返回第一个比它小的元素
     *
     * @param x
     * @return
     */
    K predecessor(K x);
    Boolean isBalance();

    int getSize();
    int getHeight();
    List<List<BinarySearchTree<K,V>.Node<K,V>>> levelOrder();

}
