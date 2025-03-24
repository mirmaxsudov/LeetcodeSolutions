package tasks.tree;

import tasks.TreeNode;

public class InsertIntoABinarySearchTree701 {
    public static void main(String[] args) {

    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);

        if (root.val == val)
            return root;

        if (val < root.val)
            root.left = insertIntoBST(root.left, val);
        else
            root.right = insertIntoBST(root.right, val);

        return root;
    }
}