package tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> r = new ArrayList<>();
        if (root == null) return r;
        Queue<TreeNode> q = new PriorityQueue<>();

        q.offer(root);

        while (!q.isEmpty()) {
            int n = q.size();
            List<Integer> l = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode f = q.poll();
                l.add(f.val);
                if (f.left != null) q.offer(f.left);
                if (f.right != null) q.offer(f.right);
            }

            r.add(l);
        }

        return r;
    }
}