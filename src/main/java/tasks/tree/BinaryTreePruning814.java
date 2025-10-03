package tasks.tree;

import tasks.TreeNode;

class BinaryTreePruning814 {
    public static void main(String[] args) {

    }

    public TreeNode pruneTree(TreeNode root) {
        if (root == null)
            return null;

        if (!isValid(root.left))
            root.left = null;
        else
            root.left = pruneTree(root.left);

        if (!isValid(root.right))
            root.right = null;
        else
            root.right = pruneTree(root.right);

        if (root.left == null && root.right == null && root.val == 0)
            return null;

        return root;
    }

    public boolean isValid(TreeNode node) {
        if (node == null)
            return false;
        if (node.val == 1)
            return true;
        return isValid(node.left) || isValid(node.right);
    }
}