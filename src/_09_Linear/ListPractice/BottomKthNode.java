package _09_Linear.ListPractice;

public class BottomKthNode {
    static class Node {
        Object value;
        Node next;

        public Node(Object value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "" + value;
        }
    }

    public Node FindKthToTail(Node head, int k) {
        if (head == null || k <= 0) {
            return head;//如果返回 null 对象则无法get node.value 这个值
        }
        Node p1 = head;
        Node p2 = head;
        int count = 0;
        while (p2 != null && count < k) {
            p2 = p2.next;
            count++;
        }
        if (count < k) {
            return head;//如果返回 null 对象则无法get node.value 这个值
        }
        while (p2 != null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        return p1;

    }

    public static void main(String[] args) {
        int arr[] = {9, 8, 7, 2, 8, 4, 2, 4, 2};
        Node head = new Node(null);//头指针一定为空
        Node p = head;
        for (int i = 0; i < arr.length; i++) {
            p.next = new Node(arr[i]);
            p = p.next;
        }
        //Test
        Node ans = new BottomKthNode().FindKthToTail(head, 9);
        System.out.println(ans.toString());
        ans = new BottomKthNode().FindKthToTail(head, 1);
        System.out.println(ans.toString());
        ans = new BottomKthNode().FindKthToTail(head, 7);
        System.out.println(ans.toString());
    }

}
