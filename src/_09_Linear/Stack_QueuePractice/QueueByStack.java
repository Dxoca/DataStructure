package _09_Linear.Stack_QueuePractice;

import java.util.Stack;

public class QueueByStack {
    /**
     * 用两个栈实现 队列的push和pop操作 队列元素为int
     * Queue 先进先出
     */
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    /**
     * 维护栈的操作 123 》 321
     *
     * @param source
     * @param target
     */
    private void move(Stack<Integer> source, Stack<Integer> target) {
        while (!source.empty()) {
            target.push(source.pop());
        }
    }

    public void enqueue(int node) {
        if (stack1.empty()) {
            move(stack2, stack1);
        }
        stack1.push(node);

    }

    public int dequeue() {
        if (stack2.empty()) {
            move(stack1, stack2);
        }
        return stack2.pop();

    }

    public static void main(String[] args) {
        QueueByStack obj = new QueueByStack();
        obj.enqueue(1);
        obj.enqueue(2);
        System.out.println(obj.dequeue());
        obj.enqueue(3);
        System.out.println(obj.dequeue());
        obj.enqueue(4);
        obj.enqueue(5);
        System.out.println(obj.dequeue());
        System.out.println(obj.dequeue());
        System.out.println(obj.dequeue());
    }
}
