package _11_Tree._01_trie;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class BinarySearchTreeTest {
    BinarySearchTree<Integer, Integer> bst = new BinarySearchTree<>();

    @Before
    public void setUp() throws Exception {

        bst.insert(4, null);
        bst.insert(1, null);
        bst.insert(10, null);
        bst.insert(14, null);
        bst.insert(7, null);
        bst.insert(16, 19);
        bst.insert(9, null);
        bst.insert(3, 15);
        bst.insert(5, null);
        bst.insert(2, null);
        bst.insert(20, null);
        bst.insert(25, null);

        System.out.println("+");
    }

    @Test
    public void insert() {
        System.out.println(bst.size);
    }

    @Test
    public void inOrder() {
        bst.inOrder(p -> {
            System.out.println(p);
        });

    }

    @Test
    public void lookupValue() {
        System.out.println(bst.lookupValue(16));
    }

    @Test
    public void min() {
        System.out.println(bst.min());
    }

    @Test
    public void max() {
        System.out.println(bst.max());
    }

    @Test
    public void remove() {
        inOrder();
        bst.remove(16);
        bst.remove(25);
        bst.remove(14);
        bst.remove(1);
        inOrder();
    }

    @Test
    public void successor() {
        System.out.println(bst.successor(3));
    }

    @Test
    public void predecessor() {
    }

    @Test
    public void isBalance() {
    }

    @Test
    public void getSize() {
        System.out.println(bst.getSize());
    }

    @Test
    public void getHeight() {

        System.out.println(bst.getHeight());
    }

    @Test
    public void levelOrder() {
        List<List<BSTNode<Integer, Integer>>> list = bst.levelOrder();
        for (List<BSTNode<Integer, Integer>> l:list) {
            System.out.println();
            for (BSTNode<Integer,Integer> r:l) {
                System.out.print(r.key+" ");
            }
        }
    }
}
