package _09_Linear.list;

import org.junit.Test;

public class SingleLinkedListTest {

    SingleLinkedList list = new SingleLinkedList();

    @Test
    public void add() {
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println(list);
    }

    @Test
    public void delete() {
        add();

        list.delete(1);
        System.out.println(list);
        list.delete(0);
        System.out.println(list);
        list.delete(0);
        System.out.println(list);
        list.delete(0);
        System.out.println(list);
    }

    @Test
    public void delete1() {
    }

    @Test
    public void update() {
    }

    @Test
    public void contains() {
    }

    @Test
    public void at() {
    }

    @Test
    public void indexOf() {
    }

    @Test
    public void toString1() {
    }
}
