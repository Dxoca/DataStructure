package _09_Linear.ListPractice;

import java.util.HashSet;

public class CircleLinkedList {
    static class Node {
        Object value;
        Node next;

        public Node(Object value) {
            this.value = value;
        }

    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Node head = new Node(null);
        structList(head, arr);

        printList(head);
        //构成环
        head.next.next.next.next.next.next = head.next;

        if (hasCircle(head)) {
            System.out.println(check(head).value);

        }
        System.out.println(hasCircle(head));
        System.out.println(beginOfCircle(head)!=null?beginOfCircle(head).value:null);//否则 null.vlaue 报错

    }

    /**
     * 步进判断有无环
     * s f终会相遇于一点
     *
     * @param head
     * @return 是否为环
     */
    private static boolean hasCircle(Node head) {
        Node s = head;
        Node f = head;
        while (true) {
            s = s.next;
            f = f.next.next;
            if (s == f) {
                return true;
            }
            if (f==null||f.next == null) {
                return false;
            }
        }
    }

    /**
     * HasCircle() 升级
     * 求相遇与何处
     * s走l-k 后相遇  实际 距离起点k步
     *
     * @param head
     * @return 返回 环头结点
     */
    public static Node beginOfCircle(Node head) {
        Node s = head;
        Node f = head;
        while (s.next != null && f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
            if (s == f) {
                break;
            }
        }
        //方式退出 无环
        if (f==null||f.next == null) {//只要一个为null
            return null;
        }
        Node p = head;
        while (p != s) {
            p = p.next;
            s = s.next;
        }
        return p;
    }

    /**
     * hashSet查重 法
     *
     * @param head
     * @return
     */
    public static Node check(Node head) {

        Node p = head;
        HashSet set = new HashSet();//hashSet查重
        while (true) {
            if (set.contains(p))
                return p;
            else {
                set.add(p);
                p = p.next;
            }
        }
    }

    /**
     * 打印
     *
     * @param h1
     */
    private static void printList(Node h1) {
        Node a = h1.next;
        while (a != null) {
            System.out.print("" + a.value + (a.next != null ? "," : "\n"));
            a = a.next;
        }
    }

    /**
     * 填入链表数据
     *
     * @param node
     * @param arr
     */
    private static void structList(Node node, int[] arr) {
        for (int i : arr) {
            node.next = new Node(i);
            node = node.next;
        }
    }

}
