package _10_Hash;


import org.junit.Test;

import java.util.Random;


public class MyHashMapTest {


    MyHashMap<String,Integer> map = new MyHashMap();

    @Test
    public void put() {
        Random r = new Random();//随机数
        //添加 操作
        map.put("one", 1);
        map.put("one",2);//覆盖上一个数
        map.put("two", 3);
        map.put("three", 4);
        map.put("three", 8);//覆盖上一个数
        System.out.println(map);
        System.out.println("ContainsKey:");
        System.out.println(map.containsKey("one"));
        System.out.println(map.containsKey("ones"));
        System.out.println("ContainsValue:");
        System.out.println(map.containsValue(1));
        System.out.println(map.containsValue(2));
        System.out.println(map.containsValue(3));
        System.out.println(map.containsValue(4));
        System.out.println(map.containsValue(8));
        System.out.println("GetKey：");
        System.out.println(map.get("one"));
        System.out.println(map.get("three"));
        System.out.println(map.get("Dxoca"));
        System.out.println("Remove:");
        System.out.println(map.remove("one"));
        System.out.println(map.remove("one"));
        System.out.println(map);


    }
}
