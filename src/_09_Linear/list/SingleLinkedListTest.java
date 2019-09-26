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
        list.delete("a");
        System.out.println(list);
        System.out.println("====");
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
    public void update() {
        add();
        list.update(2, "hhhhh");
        System.out.println(list);
        list.update(5, "hxx");
        System.out.println(list);
    }

    @Test
    public void contains() {
        add();
        System.out.println(list.contains("a"));
    }

    @Test
    public void at() {
        add();
        System.out.println(list.at(0));
        System.out.println(list.at(5));//null
    }

    @Test
    public void indexOf() {
        add();
        System.out.println(list.indexOf("a"));
        System.out.println(list.indexOf("Dxoca"));
        System.out.println(list.indexOf("c"));
    }

}
