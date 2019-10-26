package _09_Linear.Stack_QueuePractice;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CatDogAsylum {
    @Test
    public void test() {
        int[][] data = {{1, 1}, {1, -1}, {1, 0}, {1, -5}, {2, 0}, {2, -1}, {2, 0}};
        ArrayList<Integer> ans=asylum(data);
        System.out.println(ans.toString().trim());
    }

    private static class Animal {
        int type;//编号
        int time;//加入时间
        static int timeLine = 0;//全局变量 先后顺序 特征值

        Animal(int type) {
            this.type = type;
            time = timeLine++;
        }

    }

    public ArrayList<Integer> asylum(int[][] ope) {

        ArrayList<Integer> asylum = new ArrayList<>();

        Queue<Animal> cats = new LinkedList<>();
        Queue<Animal> dogs = new LinkedList<>();

        for (int[] inAndOut : ope) {
            int op = inAndOut[0];
            int typeNumber = inAndOut[1];

            if (op == 1) {//有动物进入
                if (typeNumber > 0) {//dog
                    dogs.add(new Animal(typeNumber));
                } else if (typeNumber < 0) {//cat
                    cats.add(new Animal(typeNumber));

                }
            } else if (op == 2) {//动物被收养
                if (typeNumber == 0) {//俩队列 选择最小的
                    if (!dogs.isEmpty() && (cats.isEmpty() || dogs.peek().time < cats.peek().time)) {//只有狗了 或者 狗比 猫进的早
                        asylum.add(dogs.poll().type);//出队 被收养
                    }
                    if (!cats.isEmpty() && (dogs.isEmpty() || dogs.peek().time > cats.peek().time)) {
                        asylum.add(cats.poll().type);
                    }
                } else if (typeNumber == 1) {//收养狗
                    if (!dogs.isEmpty()) {
                        asylum.add(dogs.poll().type);
                    }
                } else if (typeNumber == -1) {//收养猫
                    if(!cats.isEmpty()){
                        asylum.add(cats.poll().type);
                    }
                }
            } else {
                break;
            }
        }
        return asylum;
    }

}
