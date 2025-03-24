package tasks.tree;

import tasks.TreeNode;

public class KthSmallestElementInABST230 {
    public static void main(String[] args) {

    }

    private int count = 0;
    private int res = 0;

    public int kthSmallestVer2(TreeNode root, int k) {
        dfs(root, k);
        return res;
    }

    private void dfs(TreeNode root, int k) {
        if (root == null)
            return;

        dfs(root.left, k);

        count++;

        if (count == k) {
            res = root.val;
            return;
        }

        dfs(root.right, k);
    }

    private final TreeNode crt = new TreeNode(-1);
    private TreeNode temp = crt;

    public int kthSmallest(TreeNode root, int k) {
        dfs(root);

        temp = crt.right;

        while (k != 0) {
            k--;
            temp = temp.right;
        }

        return temp.val;
    }

    private void dfs(TreeNode root) {
        if (root == null)
            return;

        dfs(root.left);

        temp.right = new TreeNode(root.val);
        temp = temp.right;

        dfs(root.right);
    }
}