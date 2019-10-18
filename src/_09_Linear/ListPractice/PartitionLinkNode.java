package _09_Linear.ListPractice;

public class PartitionLinkNode {
    static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
//        int arr[] = {3,4,2,5,6};
        int arr1[] = {5,6,3,2,1};
        Node head, p;
        head = new Node(-1);
        p = head;
        for (int i : arr1) {
            p.next = new Node(i);
            p = p.next;
        }
        new PartitionLinkNode().partition(head, 3);

        Node p1 = head.next;
        while (p1 != null) {
            System.out.println(p1.value);
            p1 = p1.next;
        }

    }

    public Node partition(Node pHead, int x) {
        Node p = pHead;
        Node leftFirst = null;//头指针
        Node leftTail = null;
        Node rightFirst = null;//头指针
        Node rightTail = null;
        while (p != null) {
            int pValue = p.value;
            if (pValue < x) {
                if (leftTail == null) {
                    leftFirst = p;
                    leftTail = p;
                } else {
                    leftTail.next = p;
                    leftTail = leftTail.next;
                }
            } else {//>= 所以x到最后了
                if (rightTail == null) {
                    rightTail = p;
                    rightFirst = p;
                } else {
                    rightTail.next = p;
                    rightTail = rightTail.next;
                }
            }
            p = p.next;
        }
        if (leftFirst == null)//左边链表可能为空
            return rightFirst;

        leftTail.next = rightFirst;//左右两个链表链接起来
        if (rightTail != null)
            rightTail.next = null;

        return leftFirst;
    }

}
