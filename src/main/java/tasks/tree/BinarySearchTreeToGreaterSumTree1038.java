package tasks.tree;

import tasks.TreeNode;

public class BinarySearchTreeToGreaterSumTree1038 {
    public static void main(String[] args) {
    }

    private int sum = 0;

    public TreeNode bstToGst(TreeNode root) {
        dfs(root);
        return root;
    }

    private void dfs(TreeNode temp) {
        if (temp == null)
            return;

        dfs(temp.right);
        sum += temp.val;
        temp.val = sum;
        dfs(temp.left);
    }
}