package _09_Linear.list;

/**
 * 线性表或者列表的接口定义
 * 不稳定 用来链表
 * 按位置 用顺序表
 */
public interface MyList {
    /**
     * 删除相同元素
     *
     * @param element
     */
    void add(Object element);

    /**
     * 删除相同元素
     *
     * @param element
     */
    void delete(Object element);

    /**
     * 根据索引删除元素
     *
     * @param index
     */
    void delete(int index);

    /**
     * 将指定位置的元素替换成新元素
     *
     * @param index
     * @param newElement
     */
    void update(int index, Object newElement);

    /**
     * 当前列表中是否含有target这个元素。
     *
     * @param target
     * @return
     */
    boolean contains(Object target);

    /**
     * 返回指定索引处的元素
     *
     * @param index
     * @return
     */
    Object at(int index);

    /**
     * 查找element的索引(int)，如果没有返回-1
     *
     * @param element
     * @return
     */
    int indexOf(Object element);
}
