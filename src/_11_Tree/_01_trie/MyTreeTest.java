package _11_Tree._01_trie;

import org.junit.Before;
import org.junit.Test;

public class MyTreeTest {
    MyTree tree = new MyTree(new TreeNode("a"));

    @Before
    public void insertChild() {
        //初始化跟节点
        TreeNode<String> root = tree.getRoot();
        //要添加的节点
        TreeNode<String> b = new TreeNode("b");
        TreeNode<String> c = new TreeNode("c");
        TreeNode<String> d = new TreeNode("d");
        //bcd添加给a节点做儿子
        tree.insertChild(root, b);
        tree.insertChild(root, c);
        tree.insertChild(root, d);

        TreeNode<String> e = new TreeNode("e");
        TreeNode<String> f = new TreeNode("f");
        TreeNode<String> g = new TreeNode("g");
        TreeNode<String> h = new TreeNode("h");
        tree.insertChild(b, e);
        tree.insertChild(b, f);
        tree.insertChild(c, g);
        tree.insertChild(d, h);
        //e的子节点
        TreeNode<String> j = new TreeNode("j");
        TreeNode<String> i = new TreeNode("i");
        tree.insertChild(e, j);
        tree.insertChild(e, i);

    }

    @Test
    public void getSize() {
        System.out.println(tree.getSize());
    }

    @Test
    public void getRoot() {
        System.out.println(tree.getRoot());
    }

    @Test
    public void getParent() {
        System.out.println(tree.getParent(tree.getRoot()));
        System.out.println(tree.getRoot().parent);
    }

    @Test
    public void getFirstChild() {
        TreeNode<String> root = tree.getRoot();
        String key = (String) tree.getNextSibling(tree.getFirstChild(root)).key;
        System.out.println(key);
    }

    @Test
    public void getNextSibling() {

    }

    @Test
    public void getHeight() {

    }

    @Test
    public void getHeight1() {

    }

    @Test
    public void deleteChild() {
        System.out.println(tree.getSize());
        System.out.println(tree.getFirstChild(tree.getFirstChild(tree.getRoot())));
        tree.deleteChild(tree.getFirstChild(tree.getFirstChild(tree.getRoot())),0);
        System.out.println(tree.getSize());
    }

    @Test
    public void preOrder() {
    }

    @Test
    public void postOrder() {
    }

    @Test
    public void levelRder() {
    }
}
