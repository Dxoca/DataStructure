package _09_Linear.list;

import org.junit.Test;

public class MyArrayListTest {

    @Test
    public void test() {
        MyArrayList list = new MyArrayList();
        list.add("nike");
        list.add("addidiaos");
        list.add("NB");
        list.add("NB");
        list.add("NB");
        list.add("NB");
        list.add("NB");
        list.add("NB");
        list.add("NB");
        list.add("NB");
        list.add("NB");
        list.add("NB");
        list.add("NB");
        list.add("ab");
        list.add("NB");
        list.add("NB");
        list.add("NB");
        list.add("ss");
        list.delete("ab");
        System.out.println(list);
    }
}
