package tasks.tree;

import tasks.TreeNode;

public class BinaryTreeTilt563 {
    public static void main(String[] args) {

    }

    int totalTilt = 0;

    public int findTilt(TreeNode root) {
        if (root == null) return 0;
        findt(root);
        return totalTilt;
    }

    public int findt(TreeNode root) {
        if (root == null) return 0;
        int l = findt(root.left);
        int r = findt(root.right);
        totalTilt += Math.abs(l - r);
        return l + r + root.val;

    }
}