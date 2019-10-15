public class PlusLinkNode {
    static class Node {
        Object value;
        Node next;

        Node(Object value) {
            this.value = value;

        }
    }

    public static void main(String[] args) {
        int[] arr1 = {7, 4, 7, 5};
        int[] arr2 = {2, 7, 2, 3, 4};
        Node h1 = new Node(null);
        Node h2 = new Node(null);
        Node a = h1;
        Node b = h2;
        structList(a, arr1);
        structList(b, arr2);
        printList(a);
        printList(b);
        Node result = new Node(null);
        result.next = plusAB(a.next, b.next);
        printList(result);

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

    public static Node plusAB(Node a, Node b) {
        return plusAB(a, b, 0);
    }

    /**
     * @param a
     * @param b
     * @param i 进位 >value
     * @return
     */
    private static Node plusAB(Node a, Node b, int i) {
        if (a == null && b == null && i == 0) {
            return null;
        }
        int value = i;
        if (a != null) {
            value += (int) a.value;
        }
        if (b != null) {
            value += (int) b.value;
        }
        Node result = new Node(value % 10);//当前节点创建的数值
        result.next = plusAB(a == null ? null : a.next, b == null ? null : b.next, value >= 10 ? 1 : 0);
        return result;
    }

}
