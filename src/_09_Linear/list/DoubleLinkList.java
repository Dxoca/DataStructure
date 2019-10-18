package _09_Linear.list;

public class DoubleLinkList<T> implements MyList<T> {
    protected ListNode<T> first = new ListNode(null);//head
    protected ListNode<T> last = new ListNode(null);//tail
    protected int size;

    public DoubleLinkList() {//初始化两个 亚元
        first.next = last;
        last.pre = first;
    }

    /**
     * 加到 node：last 之前
     * 维护四条线
     *
     * @param element
     */
    @Override
    public void add(T element) {
        ListNode<T> newNode = new ListNode(element);

        last.pre.next = newNode;//倒数第二个指向新的
        newNode.next = last;//新的尾巴 指向 最后一个
        newNode.pre = last.pre;//新的头指向 上次最后一个的前面一个
        last.pre = newNode;//最后一个的头 指向新的

        size++;

    }

    @Override
    public void delete(T element) {
        ListNode<T> p = first.next;
        while (p != last) {//终止于 亚元
            if (p.data.equals(element)) {//当前p 匹配到了
                size--;
                p.pre.next = p.next;
                p.next.pre = p.pre;
                p.next = null;//便于被GC扫描 清除
                p.pre = null;
            }
            p = p.next;//滑动指向下一个节点
        }
    }

    @Override
    public void delete(int index) {
        if (index < 0 || index >= size) {
            return;//索引超出 [0,size)
        }
        int i = 0;
        ListNode<T> p = first.next;
        while (p != last) {
            if (i == index) {
                size--;
                p.pre.next = p.next;
                p.next.pre = p.pre;
                p.next = null;//便于被GC扫描 清除
                p.pre = null;
                break;
            }
            i++;
            p = p.next;
        }

    }

    @Override
    public void update(int index, T newElement) {
        if (index < 0 || index >= size) {
            return;//索引超出 [0,size)
        }
        int i = 0;
        ListNode<T> p = first.next;
        while (p != last) {
            if (i == index) {
                p.data = newElement;
                break;
            }
            i++;
            p = p.next;
        }
    }

    @Override
    public boolean contains(T target) {
        ListNode<T> p = first.next;
        while (p != last) {
            if (p.data.equals(target)) {
                return true;
            }
            p = p.next;
        }
        return false;
    }

    @Override
    public T at(int index) {
        if (index < 0 && index >= size) {
            return null;
        }
        int i = 0;
        ListNode<T> p = first.next;
        while (p != last) {
            if (i == index) {
                return (T) p.data;
            }
            p = p.next;
            i++;
        }
        return null;
    }

    @Override
    public int indexOf(T element) {
        ListNode<T> p = first.next;
        int i = 0;
        while (p != last) {
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
        ListNode<T> p = first.next;
        while (p != last) {
            sb.append(p.data).append(p.next != last ? "," : "");
            p = p.next;
        }
        sb.append("]");//这么写的原因是 如果为空 就[] 不然写到while 里面 while不判定就gg
        return "DoubleLinkList{" +
                "elements=" + sb.toString() +
                "size=" + size +
                '}';
    }

    ListNode<T> now = first;

    @Override
    public boolean hasNext() {
        return now.next != last;
    }

    @Override
    public T next() {
        ListNode<T> next = now.next;
        now = now.next;
        return (T) next.data;
    }
}
