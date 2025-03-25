package tasks.tree;

import tasks.TreeNode;

public class MaximumDifferenceBetweenNodeAndAncestor1026 {
    public static void main(String[] args) {

    }

    private int max = 0;

    public int maxAncestorDiff(TreeNode root) {
        dfs(root, root.val, root.val);
        return this.max;
    }

    private void dfs(TreeNode root, int min, int max) {
        if (root == null)
            return;

        this.max = Math.max(this.max, Math.max(Math.abs(min - root.val), Math.abs(max - root.val)));

        dfs(root.left, Math.min(root.val, min), Math.max(root.val, max));
        dfs(root.right, Math.min(root.val, min), Math.max(root.val, max));
    }
}