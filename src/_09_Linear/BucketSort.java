package _09_Linear;

import java.util.Arrays;

/**
 * 简单的单向链表节点
 */
class LinkedNode {
    public int value;
    public LinkedNode next;

    public LinkedNode(int value) {
        this.value = value;
    }
}
/**
 * 桶排序<br />
 * 思路：见http://www.cs.usfca.edu/~galles/visualization/BucketSort.html<br />
 * 工作的原理是将数组分到有限数量的桶子里。<br />
 * 每个桶子再个别排序（有可能再使用别的排序算法或是以递归方式继续使用桶排序进行排序）。<br />
 * 桶排序是鸽巢排序的一种归纳结果。当要被排序的数组内的数值是均匀分配的时候，桶排序使用线性时间（Θ（n））。<br />
 * 但桶排序并不是 比较排序，他不受到 O(n log n) 下限的影响。<br />
 *
 * 时间复杂度： O(N+C)，其中C=N*(logN-logM)<br />
 * 空间复杂度：N+M，M为桶的个数<br />
 * 非原址排序<br />
 * 稳定性：稳定<br />
 *
 * 桶排序假设数据会均匀入桶，在这个前提下，桶排序很快！
 */

public class BucketSort {
    public static void main(String[] args) {
        int[] arr = new BucketSort().getRandomArr(30, 1, 100);
        System.out.println(Arrays.toString(arr));
        new BucketSort().BucketSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void BucketSort(int[] arr) {
        int length = arr.length;
        LinkedNode[] bucket = new LinkedNode[length];//桶的个数 length
        int max = new BucketSort().MaxOfArr(arr);//求出max
        //入桶
        for (int i = 0; i < length; i++) {
            int value = arr[i];
            int hash = hash(value, max, length);//桶的下标
            if (bucket[hash] == null) {//空 初始化链表表头
                bucket[hash] = new LinkedNode(value);
            } else {//插入链表
                insertInto(value, bucket[hash], bucket, hash);
            }
        }
        int k = 0;//记录数组下标
        //出桶 回填array
        for (LinkedNode node : bucket) {
            if (node != null) {
                while (node != null) {
                    arr[k++] = node.value;
                    node = node.next;
                }
            }
        }
    }

    /**
     * 入桶和单链表插入类似
     *
     * @param value
     * @param head   ->bucket[hash] 某个桶
     * @param bucket
     * @param hash
     */
    private void insertInto(int value, LinkedNode head, LinkedNode[] bucket, int hash) {
        LinkedNode newNode = new LinkedNode(value);
        //小于头结点 放在头上
        //head=bucket[hash];
        if (value <= head.value) {
            newNode.next = head;
            //替换头结点
            bucket[hash] = newNode;
            return;
        }
        //否者 往后找比第一个比 当前值大 的 节点 放在其前面
        //*******【注意理解】*********
        LinkedNode p = head;
        LinkedNode pre = p;

        while (p != null && value > p.value) {
            pre = p;//p 和pre 小步向后移动！！
            p = p.next;
        }
        if (p == null) {//末尾了 没有比它大的 它是最大的
            pre.next = newNode;// 暗示newNode.next==null
        } else {//插入到pre和p之间
            pre.next = newNode;
            newNode.next = p;
        }
    }

    /**
     * 求出桶的下标
     * 当前元素*桶长度/（最大值+1）
     * 根据桶的个数来确定hash函数，这份代码适合桶的个数等于数组长度
     * @param value
     * @param max
     * @param length
     * @return
     */
    private int hash(int value, int max, int length) {
        return value * length / (max + 1);
    }

    /**
     * (数据类型)(最小值+Math.random()*(最大值-最小值+1))
     *
     * @param length
     * @param min
     * @param max
     * @return
     */
    public int[] getRandomArr(int length, int min, int max) {
        int[] a = new int[length];
        for (int i = 0; i < length; i++) {
            a[i] = (int) (min + Math.random() * (max - min + 1));
        }
        return a;
    }

    /**
     * 求出数组的最大值
     *
     * @param a
     * @return
     */
    public int MaxOfArr(int[] a) {
        int max = a[0];
        for (int i : a)
            if (i > max)
                max = i;
        return max;
    }
}
