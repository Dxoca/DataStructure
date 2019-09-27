package _09_Linear.list;

//import org.omg.CORBA.Object;

/**
 * 用顺序存储｛数组｝的方式来实现列表
 */
public class MyArrayList<T> implements MyList<T> {
    //全局变量
    private T[] elements;//真正储存元素的底层结构

    private int size = 0;//元素个数

    private int capacity = 10;//容量

    /**
     * @param capacity
     */
    public MyArrayList(int capacity) {
        this.capacity = capacity;
        elements = (T[]) new Object[capacity];//先声明Object数组 再强转T
    }

    public MyArrayList() {
        elements = (T[]) new Object[capacity];
    }

    @Override
    public void add(T element) {
        if (size == capacity) {//扩容
            capacity *= 2;//增加一倍的容量
            T[] newArr = (T[]) new Object[capacity];
            for (int i = 0; i < size; i++) {
                newArr[i] = elements[i];
            }
            elements = newArr;//把旧的空间扔掉
        }
        elements[size++] = element;

    }

    @Override
    public void delete(T element) {
        int index = indexOf(element);
        if (index >= 0) {
            delete(index);
        }
    }

    @Override
    public void delete(int index) {
        for (int i = index; i < size; i++) {
            elements[i] = elements[i + 1];
        }
        size--;
    }

    @Override
    public void update(int index, T newElement) {
        elements[index] = newElement;
    }

    @Override
    public boolean contains(T target) {
        return indexOf(target) >= 0;//巧用indexOf判断
    }

    @Override
    public T at(int index) {
        return elements[index];
    }

    @Override
    public int indexOf(T element) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element))
                return i;
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i] + (i == size - 1 ? "" : ","));
        }
        sb.append("]");
        return "MyArrayList{" +
                "elements=" + sb.toString() +
                '}';
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public T next() {
        return null;
    }

}
