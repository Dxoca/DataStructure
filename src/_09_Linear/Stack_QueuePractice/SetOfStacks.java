package _09_Linear.Stack_QueuePractice;

import org.junit.Test;

import java.util.ArrayList;

public class SetOfStacks {
    public ArrayList<ArrayList<Integer>> setOfStack(int[][] ope, int size) {

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> currStack = new ArrayList<>(size);

        list.add(currStack);

        for (int[] opAndValue : ope) {
            int op = opAndValue[0];
            int value = opAndValue[1];

            if (op == 1) {//1Push
                if (currStack.size() == size) {//当前满了
                    currStack = new ArrayList<>(size);//创建一个新栈
                    list.add(currStack);
                }
                currStack.add(value);
            } else {//2pop
                if (currStack.size() == 0) {
                    list.remove(currStack);//站的列表中移除
                    currStack = list.get(list.size() - 1);//被操作的栈是列表中的上一个栈
                }
                currStack.remove(currStack.size() - 1);

            }

        }
        return list;
    }

    @Test
    public void test() {
        int[][] ope = new int[3][2];
        //push
        ope[0][0] = 1;
        ope[1][0] = 1;
        ope[2][0] = 1;
        //value
        ope[0][1] = 1;
        ope[1][1] = 2;
        ope[2][1] = 3;

        ArrayList<ArrayList<Integer>> ans = setOfStack(ope, 1);
        for (ArrayList<Integer> a:ans) {

            for (int i = 0; i < a.size(); i++) {
                System.out.println(a.get(i));
            }
            System.out.println("+++");

        }
    }

}
