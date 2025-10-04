package tasks.tree;

import tasks.TreeNode;

public class ConstructStringFromBinaryTree606 {
    public static void main(String[] args) {

    }

    private StringBuilder sb = new StringBuilder();

    public String tree2str(TreeNode root) {
        dfs(root);
        return sb.toString();
    }

    private void dfs(TreeNode root) {
        if (root == null)
            return;

        sb.append(root.val);

        if (root.left == null && root.right == null)
            return;

        if (root.left == null) {
            sb.append("()");
        } else {
            sb.append("(").append(root.val);
            dfs(root.left);
            sb.append(")");
        }

        if (root.right != null) {
            sb.append("(").append(root.val);
            dfs(root.right);
            sb.append(")");
        }
    }
}