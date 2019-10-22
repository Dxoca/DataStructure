package _09_Linear.list;

/*节点*/

public class ListNode<T> {
    T data;//数据
    ListNode<T> next;//指向下一个节点的指针
    ListNode<T> pre;

    public ListNode(T data) {//初始化构造器
        this.data = data;
    }

    public ListNode<T> getPre() {
        return pre;
    }

    public T getData() {
        return data;
    }

    public void setNext(ListNode<T> next) {
        this.next = next;
    }

    public void setPre(ListNode<T> pre) {
        this.pre = pre;
    }

    public ListNode<T> getNext() {
        return next;
    }
}
