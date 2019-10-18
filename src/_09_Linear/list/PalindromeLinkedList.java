package _09_Linear.list;

import java.util.Stack;

/**
 * 回文链表 检测回文
 */
public class PalindromeLinkedList {
    static class Node {
        Object value;

        Node next;

        Node(Object value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 4, 3, 2, 1};
        int arr1[] = {1, 2, 3, 4, 5, 3, 2, 1};
        int arr2[] = {1, 2, 3, 4, 3, 2, 1};
        Node head = new Node(null);
        Node p = head;
        for (int i : arr) {
            p.next = new Node(i);
            p = p.next;
        }
        System.out.println(checkPalindrome(head));
    }

    private static boolean checkPalindrome(Node head) {
        Node f = head.next;
        Node s = head.next;
        Stack<Node> stack = new Stack<>();
        while (s != null && s.next != null) {
            stack.push(f);//入栈
            f = f.next;
            s = s.next.next;
        }
        if (s != null) {//奇数个//1 2 3 4(f) 1 2 3 4(s) s==null 就是  奇数个
            f = f.next;//后移
        }
        System.out.println("第二个指针的位置：" + f.value);
        while (!stack.empty()) {
            if (stack.pop().value == f.value) {//出栈
                f = f.next;
            } else {
                return false;
            }
        }
        return true;
    }

}
