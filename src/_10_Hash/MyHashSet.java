package _10_Hash;

import java.util.Iterator;

public class MyHashSet<E> implements IHashSet<E> {

    private MyHashMap<E, E> map = new MyHashMap<>();

    @Override
    public void add(E key) {
        map.put(key, null);//只需要Key即可
    }

    @Override
    public E remove(E key) {
        return map.remove(key);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean contains(E key) {
        return map.containsKey(key);
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override//调用map的迭代器
    public Iterator<E> iterator() {
        Iterator<MyHashMap.Node> iter = map.iterator();
        return new Iterator<E>() {
            @Override
            public boolean hasNext() {
                return iter.hasNext();
            }

            @Override
            public E next() {
                return (E) iter.next().key;
            }
        };
    }

    @Override
    public String toString() {
        Iterator<MyHashMap.Node> iterator = map.iterator();
        StringBuilder sb = new StringBuilder();
        if (iterator.hasNext() == false)
            return null;
        while (iterator.hasNext()) {
            sb.append(iterator.next().key + ",");
        }
        return sb.toString();
    }

}