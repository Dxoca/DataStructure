package _09_Linear.Stack;

import org.junit.Before;
import org.junit.Test;

import java.util.EmptyStackException;

public class MyStackTest {
    MyStack<String> stack = new MyStack<>();

    @Before
    public void init() {
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
    }

    @Test
    public void pop() {
        try {
            System.out.println(stack.pop());

            System.out.println(stack.empty());

            System.out.println(stack.pop());
            System.out.println(stack.pop());

            System.out.println("当前empty状态：" + stack.empty());
            System.out.println("当前size状态：" + stack.getSize());
            System.out.println("当前栈顶元素：" + stack.peek());

            System.out.println(stack.pop());

            System.out.println(stack.pop());//溢出

        } catch (EmptyStackException e) {
            System.out.println("栈溢出了");
            System.out.println(stack.empty());
        }

    }
}
