package _10_Hash;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

public class MyHashSetTest {
    MyHashSet<Integer> set = new MyHashSet<>();

    @Before
    public void add() {
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(1);

    }

    @Test
    public void remove() {
        System.out.println(set);
        set.remove(1);
        System.out.println(set);

    }

    @Test
    public void clear() {
        set.clear();
        System.out.println(set);
    }

    @Test
    public void contains() {
        System.out.println(set.contains(1));
        System.out.println(set.contains(66));
    }

    @Test
    public void isEmpty() {
        System.out.println(set.isEmpty());
        set.clear();
        System.out.println(set.isEmpty());
    }

    @Test
    public void size() {
        System.out.println(set.size());
        set.remove(1);
        System.out.println(set.size());
        System.out.println(set);
        set.clear();
        System.out.println(set.size());
        System.out.println(set);

    }

    @Test
    public void iter() throws Exception {
        Iterator<Integer> iter = set.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

}
