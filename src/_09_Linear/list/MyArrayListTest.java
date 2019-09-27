package _09_Linear.list;

import org.junit.Test;

public class MyArrayListTest {
    MyArrayList<String> list = new MyArrayList<String>();
    @Test
    public void add() {
        list.add("asd");
        list.add("va");
        list.add("bab");
        System.out.println(list);
    }
    @Test
    public void iter(){
        while (list.hasNext()){
            Object next= list.next();//泛型测试
            System.out.println(next);
        }
    }

}
