package _10_Hash;

import java.util.Iterator;

public interface IHashSet<E> {
    void add(E key);
    E remove(E key);
    void clear();
    boolean contains(E key);
    boolean isEmpty();
    int size();
    Iterator<E> iterator();

}
