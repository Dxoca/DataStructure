package _11_Tree._01_trie;

import java.util.List;

public interface ITree<E> {
    int getSize();//获取节点数
    TreeNode<E> getRoot();//返回根
    TreeNode<E> getParent(TreeNode<E> x);//返回节点的父节点
    TreeNode<E> getFirstChild(TreeNode<E> x);//节点获取第一个孩子
    TreeNode<E> getNextSibling(TreeNode<E> x);//返回一个节点的下一个兄弟
    int getHeight(TreeNode<E> x);//子树高度

    void insertChild(TreeNode<E> x,TreeNode<E> child);//插入子节点（孩子）
    void deleteChild(TreeNode<E>  x,int i);//删孩子 节点编号
    List<TreeNode<E>> preOrder(TreeNode<E> x);//前序遍历 先根遍历BA-C
    List<TreeNode<E>> postOrder(TreeNode<E> x);//后序遍历 后根遍历AC-B
    List<TreeNode<E>> levelOrder(TreeNode<E> x);//层次遍历 ABC-
    //

}
