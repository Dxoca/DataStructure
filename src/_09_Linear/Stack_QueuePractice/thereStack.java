package _09_Linear.Stack_QueuePractice;

import java.util.Arrays;

//只用一个数组实现三个栈 131
public class thereStack {

    static class Stack {
        int[] arr;
        int s1l;//栈头 left
        int s1r;//尾巴 right
        int s1c = 0;//元素计数 count

        int s2l;
        int s2r;
        int s2c = 0;
        int s3l;
        int s3r;
        int s3c = 0;

        Stack(int[] arr) {
            int start = 0;
            int end = arr.length - 1;
            this.arr = arr;
            //计算每个栈的头尾 假设arr[30]
            s1l = start;//0
            s1r = end / 3;//9

            s2l = end / 3 + 1;//10
            s2r = 2 * end / 3;//19

            s3l = 2 * end / 3 + 1;//20
            s3r = end;//29
        }

        /**
         * 对应桶里k放入指定元素
         *
         * @param k
         * @param e
         */
        public void push(int k, int e) {
            int first, end;
            switch (k) {
                case 0:
                    first = s1l;//该栈 的头
                    end = s1r;//尾巴
                    if (s1c >= end - first + 1) {//满了
                        System.out.println("栈1满");
                        return;

                    } else if (arr[s1l] == 0) {//头元素
                        arr[s1l] = e;
                        s1c++;
                    } else {
                        while (arr[end] == 0) {//找到第一个逆序非空的元素
                            end--;
                        }
                        for (int i = end; i >= first; i--) {//从第一个逆序非空元素开始 都往后移动一个 并且已经解决满了的前提（一定是 小雨n-1个空间）
                            arr[i + 1] = arr[i];
                        }
                        arr[first] = e;//移动完成 目标元素放到 首部
                        s1c++;//计数+1
                    }

                    break;
                case 1:
                    first = s2l;
                    end = s2r;
                    if (s2c >= end - first + 1) {//满了
                        System.out.println("栈2满");
                        return;

                    } else if (arr[s2l] == 0) {//头元素
                        arr[s2l] = e;
                        s2c++;
                    } else {
                        while (arr[end] == 0) {//找到第一个逆序非空的元素
                            end--;
                        }
                        for (int i = end; i >= first; i--) {
                            arr[i + 1] = arr[i];
                        }
                        arr[first] = e;
                        s2c++;
                    }
                    break;
                case 2:
                    first = s3l;
                    end = s3r;
                    if (s3c >= end - first + 1) {//满了
                        System.out.println("栈3满");
                        return;

                    } else if (arr[s3l] == 0) {//头元素
                        arr[s3l] = e;
                        s3c++;
                    } else {
                        while (arr[end] == 0) {//找到第一个逆序非空的元素
                            end--;
                        }
                        for (int i = end; i >= first; i--) {
                            arr[i + 1] = arr[i];
                        }
                        arr[first] = e;
                        s3c++;
                    }
                    break;
            }
        }
    }
    public static void main(String[] args) {
        int arr[] = new int[15];
        Stack s = new Stack(arr);
        s.push(0, 1);
        s.push(0, 1);
        s.push(0, 1);
        s.push(0, 1);
        s.push(0, 1);
        s.push(0, 1);

        s.push(1, 2);
        s.push(1, 3);
        s.push(1, 4);
        s.push(1, 5);
        s.push(1, 6);
        s.push(1, 7);

        s.push(2, 90);
        s.push(2, 90);
        s.push(2, 90);
        s.push(2, 90);
        s.push(2, 91);
        s.push(2, 92);
        
        System.out.println(Arrays.toString(arr));

    }
}
