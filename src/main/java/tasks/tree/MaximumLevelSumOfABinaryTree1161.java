package tasks.tree;

import tasks.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MaximumLevelSumOfABinaryTree1161 {
    public static void main(String[] args) {

    }

    public int maxLevelSumVer2(TreeNode root) {
        Map<Integer, Integer> mp = new HashMap<>();

        readAndAdd(mp, root, 1);

        int max = Integer.MIN_VALUE, maxIndex = -1;

        for (Map.Entry<Integer, Integer> e : mp.entrySet()) {
            if (e.getValue() == max)
                maxIndex = Math.min(maxIndex, e.getKey());
            else if (e.getValue() > max) {
                max = e.getValue();
                maxIndex = e.getKey();
            }
        }

        return maxIndex;
    }

    private void readAndAdd(Map<Integer, Integer> mp, TreeNode root, int level) {
        if (root == null)
            return;

        mp.put(level, mp.getOrDefault(level, 0) + root.val);
        readAndAdd(mp, root.left, level + 1);
        readAndAdd(mp, root.right, level + 1);
    }

    public int maxLevelSum(TreeNode root) {
        if (root == null)
            return -1;

        Queue<Helper> q = new LinkedList<>();
        q.offer(new Helper(root, 1));

        int[] vals = new int[maxDepth(root, 0)];

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Helper helper = q.poll();
                TreeNode node = helper.node;
                vals[helper.level - 1] += node.val;

                if (node.left != null)
                    q.offer(new Helper(node.left, helper.level + 1));
                if (node.right != null)
                    q.offer(new Helper(node.right, helper.level + 1));
            }
        }

        int max = vals[0], maxIndex = 0;

        for (int i = 1; i < vals.length; i++) {
            if (max < vals[i]) {
                max = vals[i];
                maxIndex = i;
            }
        }

        return maxIndex + 1;
    }

    private int maxDepth(TreeNode root, int depth) {
        if (root == null)
            return depth;

        return Math.max(maxDepth(root.left, depth + 1), maxDepth(root.right, depth + 1));
    }

    class Helper {
        TreeNode node;
        int level;

        public Helper(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }
}