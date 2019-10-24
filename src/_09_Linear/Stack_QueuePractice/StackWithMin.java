package _09_Linear.Stack_QueuePractice;

import _09_Linear.Stack.IStack;
import _09_Linear.Stack.MyStack;
import _09_Linear.list.DoubleLinkList;
import _09_Linear.list.ListNode;
import org.junit.Test;

import java.util.EmptyStackException;

public class StackWithMin<T> extends DoubleLinkList<T> implements IStack<T> {
    @Test
    public void test()throws Exception {
        StackWithMin stack = new StackWithMin<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(-5);
        stack.push(5);
        System.out.println(stack.min_O1());
//        System.out.println(stack.min_On());
        stack.pop();
        stack.pop();
        System.out.println(stack.min_O1());
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(stack.min_O1());

    }

    @Override
    public void push(T e) {
        add(e);

        //维护最小值栈 当然还可以节约空间 减少重复
        if (brother.empty()) {
            brother.push(e);
        } else {
            T peek = brother.peek();
            if ((Integer) e < (Integer) peek) {
                brother.push(e);
            } else {
                brother.push(peek);
            }
        }

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

        brother.pop();//兄弟也弹出

        return res;

    }

    /**
     * O(n) 遍历
     *
     * @return
     */
    public int min_On() {
        ListNode<T> h = first.getNext();
        int min = -1;
        while (h != last) {
            if ((Integer) h.getData() <= min) {
                min = (Integer) h.getData();
            }
            h = h.getNext();//后移
        }
        return min;
    }



    /**
     * O(1) 空间换时间
     * 再Push时 维护最小值栈
     * @return
     * @throws Exception
     */
    //维护栈
    private MyStack<T> brother = new MyStack();

    public int min_O1() throws Exception {
        if (!brother.empty())
            return (Integer) brother.peek();
        else
            throw new Exception("没有元素了 所以无最小值");
    }

    //----------------------------------------
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
