package tasks;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal103 {
    public static void main(String[] args) {

    }


    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> r = new ArrayList<>();

        Queue<Object[]> q = new LinkedList<>();

        q.add(new Object[]{0, root});

        boolean fromLeft = true;
        int cl = 0, l = 1;

        List<Integer> list = new ArrayList<>();

        while (!q.isEmpty()) {
            Object[] p = q.poll();
            TreeNode pt = (TreeNode) p[1];
            int pl = (int) p[0];

            if (pt == null) continue;

            if (cl != pl) {
                r.add(list);
                list = new ArrayList<>();
                fromLeft = !fromLeft;
                l++;
                cl = pl;

            }
            if (fromLeft) list.add(pt.val);
            else list.addFirst(pt.val);

            if (pt.left != null) q.add(new Object[]{l, pt.left});
            if (pt.right != null) q.add(new Object[]{l, pt.right});
        }

        if (!list.isEmpty())
            r.add(list);

        return r;
    }
}