package tasks.tree;

import tasks.TreeNode;

public class DeleteLeavesWithAGivenValue1325 {
    public static void main(String[] args) {

    }

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        dfs(root.left, root, target);
        dfs(root.right, root, target);

        if (root.left == null && root.right == null && root.val == target)
            return null;

        return root;
    }

    private void dfs(TreeNode root, TreeNode parent, int target) {
        if (root == null)
            return;

        dfs(root.left, root, target);
        dfs(root.right, root, target);

        if (root.val == target && root.left == null && root.right == null) {
            if (parent.left == root)
                parent.left = null;
            else
                parent.right = null;
        }
    }
}