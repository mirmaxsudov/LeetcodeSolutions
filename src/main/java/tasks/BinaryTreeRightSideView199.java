package tasks;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView199 {
    public static void main(String[] args) {

    }

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if (root == null)
            return res;

        Queue<Helper> q = new LinkedList<>();
        q.offer(new Helper(root, 1));

        while (!q.isEmpty()) {
            for (int i = 0; i < q.size(); i++) {
                Helper node = q.poll();
                // ToDo
                if (res.size() + 1 == node.level)
                    res.add(node.node.val);

                // Insert next node from right to left;
                if (node.node.right != null)
                    q.offer(new Helper(node.node.right, node.level + 1));
                if (node.node.left != null)
                    q.offer(new Helper(node.node.left, node.level + 1));
            }
        }

        return res;
    }

    static class Helper {
        TreeNode node;
        int level;

        public Helper(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }
}