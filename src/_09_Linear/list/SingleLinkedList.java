package _09_Linear.list;

public class SingleLinkedList implements MyList {
    private ListNode first;//两个指针交互
    private ListNode last;
    private int size;

    @Override
    public void add(Object element) {
        //新增一个节点
        if (first == null) {//第一个节点
            first = new ListNode(element);
            last = first;//last==first 所以 first空 存储其他数据
        } else {
            //last.next指向新的节点
            last.next = new ListNode(element);//第一次:last 等价于 first 同一个对象 所以 first.next=last.next or data
            last = last.next;//现在的last是 新元素的节点 其中next等待下次 赋值//所以下一次就是 last.next.next

        }
        size++;//链表存的元素cnt

    }

    @Override
    public void delete(Object element) {
        ListNode p = first;
        ListNode pre = null;//first的前驱为空
        while (p != null) {
            if (p.data.equals(element)) {//当前p 匹配到了
                size--;
                if (p == first) {//【特判】 头指针 为删除目标 特判
                    first = first.next;
                } else {
                    pre.next = p.next;
                }
            }
            pre = p;//记录上一次比对的节点
            p = p.next;//滑动指向下一个节点
        }
    }

    @Override
    public void delete(int index) {
        if (index < 0 || index >= size) {
            return;//索引超出 [0,size)
        }
        int i = 0;
        ListNode p = first;
        ListNode pre = null;//first的前驱为空
        while (p != null) {
            if (i == index) {
                size--;
                if (p == first) {// 【特判】头指针 为删除目标 特判
                    first = first.next;
                } else {
                    pre.next = p.next;
                }
                break;//退出

            }
            pre = p;
            p = p.next;
            i++;
        }

    }

    @Override
    public void update(int index, Object newElement) {
        if (index < 0 || index >= size) {
            return;//索引超出 [0,size)
        }
        int i = 0;
        ListNode p = first;
        while (p != null) {
            if (i == index) {
                p.data = newElement;
                break;
            }
            i++;
            p = p.next;
        }
    }

    @Override
    public boolean contains(Object target) {
        ListNode p = first;
        while (p != null) {
            if (p.data.equals(target)) {
                return true;
            }
            p = p.next;
        }
        return false;
    }

    @Override
    public Object at(int index) {
        if (index < 0 && index >= size) {
            return null;
        }
        int i = 0;
        ListNode p = first;
        while (p != null) {
            if (i == index) {
                return p.data;
            }
            p = p.next;
            i++;
        }
        return null;
    }

    @Override
    public int indexOf(Object element) {
        ListNode p = first;
        int i = 0;
        while (p != null) {
            if (p.data.equals(element)) {
                return i;
            }
            p = p.next;
            i++;
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        ListNode p = first;//头指针
        while (p != null) {//当前数据不是空
            sb.append(p.data).append(p.next != null ? "," : "");//判断是不是最后一个节点
            p = p.next;
        }
        sb.append("]");//这么写的原因是 如果为空 就[] 不然写到while 里面 while不判定就gg
        return "SingleLinkedList{" +
                "elements=" + sb.toString() +
                "size=" + size +
                '}';
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object next() {
        return null;
    }
}
