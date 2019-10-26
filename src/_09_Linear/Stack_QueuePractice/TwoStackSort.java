package _09_Linear.Stack_QueuePractice;

import java.util.ArrayList;
import java.util.Stack;

public class TwoStackSort {
    public static void main(String[] args) {
        int[] arr = {80, 2, 3, 14, 5, 19, 4, 70};
        ArrayList<Integer> res = new TwoStackSort().twoStackSort(arr);
        for (int a : res) {
            System.out.println(a);
        }
    }

    public ArrayList<Integer> twoStackSort(int[] number) {
        // 初始化原始栈
        Stack<Integer> source = new Stack<>();

        for (int i = 0; i < number.length; i++) {
            source.push(number[i]);
        }
        Stack<Integer> target = twoStackSort(source);

        ArrayList<Integer> list = new ArrayList<>();

        while (!target.empty()) {
            list.add(target.pop());//从栈顶取出 从大大小 --> list
        }
        return list;

    }

    public Stack<Integer> twoStackSort(Stack<Integer> source) {
        Stack<Integer> target = new Stack<>();
        while (!source.empty()) {
            int v1 = source.pop();//揭开 盖子
            if (target.empty()) {
                target.push(v1);
            } else {//比较
                if (v1 >= target.peek())//比盖子大 就 压进去 大的在栈顶
                    target.push(v1);
                else {
                    while (!target.empty() && v1 < target.peek()) {//逆序 装回去
                        source.push(target.pop());
                    }
                    target.push(v1);
                }
            }
        }
        return target;
    }
}
