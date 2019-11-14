package _11_Tree._01_trie;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static java.lang.Math.max;

public class MyTree<E> implements ITree<E> {
    private int size = 0;
    private TreeNode root;

    public MyTree(TreeNode root) {
        this.root = root;
        size++;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public TreeNode<E> getRoot() {
        return root;
    }

    @Override
    public TreeNode<E> getParent(TreeNode<E> x) {
        return x.parent;
    }

    /**
     * 返回节点的第一个孩子
     *
     * @param x
     * @return
     */
    @Override
    public TreeNode<E> getFirstChild(TreeNode<E> x) {
        return x.children.get(0);
    }

    /**
     * 返回我的右边的兄弟
     *
     * @param x
     * @return
     */
    @Override
    public TreeNode<E> getNextSibling(TreeNode<E> x) {
        //回溯 认祖归宗 先找到父亲 然后得到孩子列表 获取我的位置 +1就是兄弟的位置
        List<TreeNode<E>> children = x.parent.children;
        int i = children.indexOf(x);//找到x的索引
        try {
            return children.get(i + 1);
        } catch (Exception e) {//如果x的最后一个孩子
            return null;
        }
//        if(i==children.size()-1){
//            return null;
//        }else{
//            return children.get(i+1);
//        }
    }

    /**
     * 返回整棵树的高度
     *
     * @return
     */
    public int getHeight() {
        return getHeight(root);
    }

    /**
     * 返回x的高度 DFS 递归算法
     *
     * @param x
     * @return
     */
    @Override
    public int getHeight(TreeNode<E> x) {
        if (x == null) {
            return 0;
        } else {
            int h = 0;
            for (int i = 0; i < x.children.size(); i++) {
                h = max(h, getHeight(x.children.get(i)));
            }
            return h + 1;
        }
    }

    /**
     * 增加节点 父子关系
     *
     * @param parent
     * @param child
     */
    @Override
    public void insertChild(TreeNode<E> parent, TreeNode<E> child) {
        if (parent.children == null) {
            parent.children = new ArrayList<>();
        }
        //双向确定关系
        parent.children.add(child);
        child.parent=parent;

        size++;
    }

    /**
     * 删除x节点的孩子 有问题！！
     *
     * @param x
     * @param i
     */
    @Override
    public void deleteChild(TreeNode<E> x, int i) {
//        int n = x.children.size();
//        for (int j = n-1; j >=0; j--) {
//            System.out.println(x.children.remove(j));
//            size--;
//        }
        x.children.remove(i);
        size--;

    }

    @Override
    public List<TreeNode<E>> preOrder(TreeNode<E> x) {
        return null;
    }

    @Override
    public List<TreeNode<E>> postOrder(TreeNode<E> x) {
        return null;
    }

    /**
     * bfs
     * 深搜用递归 宽搜用队列
     * 队列 （队）弹一个 加n个（队）
     * 两个游标 来分层对比 出的最后一个 那么下一层进的也是最后一个
     * @param x
     * @return
     */
    @Override
    public List<List<TreeNode<E>>> levelOrder(TreeNode<E> x) {
        List<List<TreeNode<E>>> res = new ArrayList<>();//list的list
        Queue<TreeNode<E>> q = new LinkedList<>();
        q.add(x);//初始化
        TreeNode<E> last = x;//标记上一行的最末节点
        TreeNode<E> nlast = null;//标记最新加入队列的节点
        List<TreeNode<E>> l = new ArrayList<>();//第一行的list
        res.add(l);

        while (!q.isEmpty()) {
            TreeNode<E> peek = q.peek();
            //把即将弹出的节点的子节点加入队列
            if (peek.children != null) {
                for (TreeNode<E> n : peek.children) {
                    q.add(n);
                    nlast = n;
                }
            }
            l.add(q.poll());//弹出 加入到当前层列表

            if (peek == last && !q.isEmpty()) {//如果现在弹出的节点是最前标记的最后节点 就要切换列表
                l = new ArrayList<>();//创建新的一层
                res.add(l);
                last = nlast;//更新游标
            }
        }
        return res;
    }
}
