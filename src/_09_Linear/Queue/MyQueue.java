package _09_Linear.Queue;

import _09_Linear.list.DoubleLinkList;
import _09_Linear.list.ListNode;

public class MyQueue<T> extends DoubleLinkList<T> implements IQueue<T> {

    @Override
    public void enqueue(T e) {
        super.add(e);
    }

    @Override
    public T dequeue() {
        ListNode<T> h = first.getNext();
        first.setNext(h.getNext());
        h.setNext(null);
        h.setPre(null);
        size--;
        return h.getData();
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean empty() {
        return getSize()==0;
    }

    @Override
    public T peek() {
        return first.getNext().getData();
    }
}
