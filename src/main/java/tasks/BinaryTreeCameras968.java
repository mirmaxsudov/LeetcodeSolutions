package tasks;

import java.util.Stack;

public class BinaryTreeCameras968 {
    public static void main(String[] args) {

    }


    public int minCameraCover(TreeNode root) {
        // 1. Single node.
        if (root.left == null && root.right == null)
            return 1;

        dfs(root);
        return result;
    }

    int result = 0;
    boolean canSetToCameraToNodesFromLeft = false;

    private void dfs(TreeNode root) {
        if (root == null)
            return;

        dfs(root.left);

        if (root.left == null && root.right == null)
            canSetToCameraToNodesFromLeft = true;

        dfs(root.right);
    }
}
