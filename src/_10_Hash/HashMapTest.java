package _10_Hash;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

/**
 * HashMap测试程序
 */
public class HashMapTest {
    public static void main(String[] args) {
        testHashMapAPIs();
    }

    private static void testHashMapAPIs() {
        //初始化随机数种子
        Random r = new Random();
        //新建 HashMap
        HashMap map = new HashMap();
        //添加 操作
        map.put("one", r.nextInt(1));
        map.put("one", r.nextInt(2));//覆盖上一个数
        map.put("two", r.nextInt(3));
        map.put("three", r.nextInt(4));

        //打印map
        System.out.println(map);

        //通过Iterator遍历key-value
        Iterator iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            System.out.println("next:" + entry.getKey() + " - " + entry.getValue());
        }

        //HashMap的键值对个数
        System.out.println("size:" + map.size());

        //containsKey(Object key):是否包含键key
        System.out.println("contains key two:" + map.containsKey("two"));
        System.out.println("contains key five:" + map.containsKey("five"));

        //remove(Object key):删除键key对应的键值对
        map.remove("three");

        System.out.println(map);

        //clear() 清空HashMap
        map.clear();

        //isEmpty()  HashMap是否为空
        System.out.println((map.isEmpty() ? "map is empty" : "map is not empty"));
    }
}
