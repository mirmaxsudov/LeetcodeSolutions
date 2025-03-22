package tasks.tree;

import tasks.TreeNode;

public class SumOfNodesWithEvenValuedGrandparent1315 {
    public static void main(String[] args) {

    }

    public int sumEvenGrandparent(TreeNode root) {
        if (root == null)
            return 0;

        if (root.left == null && root.right == null)
            return 0;

        return dfs(root, root.left.left) + dfs(root, root.left.right) + dfs(root, root.right.left) + dfs(root, root.right.right);
    }

    private int dfs(TreeNode parent, TreeNode child) {
        if (child == null)
            return 0;

        boolean isParentEven = parent.val % 2 == 0;

        int sum = child.left != null ? dfs(parent.left, child.left) : 0;
        sum += child.right != null ? dfs(child, child.right) : 0;

        return isParentEven ? sum + child.val : sum;
    }
}