package tasks.tree;

import tasks.TreeNode;

public class PathSumIII437 {
    public static void main(String[] args) {

    }

    int res = 0;

    public int pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum, 0);
        return res;
    }

    private void dfs(TreeNode root, int targetSum, int crtSum) {
        if (root == null)
            return;

        crtSum += root.val;

        if (crtSum == targetSum)
            this.res++;

        dfs(root.left, targetSum, crtSum);
        dfs(root.right, targetSum, crtSum);
        dfs(root.left, targetSum, root.val);
        dfs(root.right, targetSum, root.val);
    }
}