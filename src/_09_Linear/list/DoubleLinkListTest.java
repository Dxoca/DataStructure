package _09_Linear.list;

import org.junit.Test;

public class DoubleLinkListTest {
    DoubleLinkList list = new DoubleLinkList();


    @Test
    public void add() {
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        System.out.println(list);
    }

    @Test
    public void delete() {
        add();
        System.out.println("deleteTest:");
        list.delete("a");
        System.out.println(list);
        list.delete("e");
        System.out.println(list);
    }

    @Test
    public void delete1() {
        add();
        System.out.println("deleteTestOfIndex:");
        list.delete(1);
        System.out.println(list);
    }

    @Test
    public void update() {
        add();
        list.update(1,'D');
        System.out.println(list);
    }

    @Test
    public void contains() {
        add();
        System.out.println(list.contains("b"));
    }

    @Test
    public void at() {
        add();
        System.out.println(list.at(4));
    }

    @Test
    public void indexOf() {
        add();
        System.out.println(list.indexOf("b"));
    }
}
