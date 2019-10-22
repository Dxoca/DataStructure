package _09_Linear.Queue;

public interface IQueue<T> {
    /**
     * 入队 追加到尾部
     * @param e
     */
    void enqueue(T e);

    /**
     * 出队 取出头部
     * @return
     */
    T dequeue();

    /**
     * 返回队列的大小
     * @return
     */
    int getSize();

    /**
     * 判断是否为空
     * @return
     */
    boolean empty();

    /**
     * 取队首元素
     * @return
     */
    T peek();
}
