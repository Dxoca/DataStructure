package _09_Linear.Stack;

public interface IStack<T> {
    /**
     * 元素入栈
     * @param e
     */
    void push(T e);

    /**
     * 弹出栈顶（栈中无此元素）
     * @return
     */
    T pop();

    /**
     * 是否空栈
     * @return
     */
    boolean empty();

    /**
     * 栈内元素个数
     * @return
     */
    int getSize();

    /**
     * 查看栈顶的元素 <br>不弹出
     * @return
     */
    public T peek();

}
