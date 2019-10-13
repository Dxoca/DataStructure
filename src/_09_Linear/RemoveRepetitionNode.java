package _09_Linear;

import java.util.HashSet;

public class RemoveRepetitionNode {
    private static class Node {
        Object value;
        Node next;

        public Node(Object value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 6, 4, 2, 7, 6, 6, 6};
        Node head = new Node(null);//哑元
        Node p = head;
        for (int i = 0; i < arr.length; i++) {
            p.next = new Node(arr[i]);
            p = p.next;
        }
        rr(head);//有缓冲区
//        rr2(head);//无缓冲区
        Node p1 = head.next;
        while (p1 != null) {
            System.out.println(p1.value);
            p1 = p1.next;
        }

    }

    /**
     * 无缓冲区 删除重复节点
     * 使用哨兵 检测 重复
     *
     * @param head
     */
    private static void rr2(Node head) {
        Node pre = head;
        Node p = pre.next;
        while (p != null) {
            Node sentry = p;//哨兵 并保持不变
            while (p.next != null) {//从哨兵之后开始比较
                if (sentry.value == p.next.value) {// 重复
                    p.next = p.next.next;
                } else {
                    p = p.next;
                }
            }
            p = pre;//恢复p
            p = p.next;//p后移
            pre = p;//保存p
        }

    }

    /**
     * 使用缓冲区
     *
     * @param head
     */
    private static void rr(Node head) {
        HashSet set = new HashSet();//开辟新空间
        Node p1 = head.next;
        Node pre = head;
        while (p1 != null) {
            if (set.contains(p1.value)) {//重复
                System.out.println("delete:" + p1.value);
                pre.next = p1.next;//删除
            } else {
                set.add(p1.value);//加入队列
                pre=p1;
            }
            //pre=p1;
            p1 = p1.next;
        }
    }
}
