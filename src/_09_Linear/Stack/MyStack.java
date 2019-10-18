package _09_Linear.Stack;

import _09_Linear.list.DoubleLinkList;
import _09_Linear.list.ListNode;

import java.util.EmptyStackException;

public class MyStack<T> extends DoubleLinkList<T> implements IStack<T> {
    @Override
    public void push(T e) {
        add(e);
    }

    @Override
    public T pop() {
        if (size <= 0) throw new EmptyStackException();
        ListNode<T> the = super.last.getPre();//last 的前一个
        T res = the.getData();

        the.getPre().setNext(last);//目标元素的前一个 指向最后
        last.setPre(the.getPre());//最后一个元素指向目标元素的前一个
        the.setPre(null);
        the.setNext(null);
        size--;

        return res;

    }

    @Override
    public boolean empty() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public T peek() {
        return last.getPre().getData();
    }
}
