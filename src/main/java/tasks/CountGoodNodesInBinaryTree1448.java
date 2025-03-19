package tasks;

import java.util.ArrayList;
import java.util.List;

public class CountGoodNodesInBinaryTree1448 {
    public static void main(String[] args) {

    }

    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    private int dfs(TreeNode root, int max) {
        if (root == null)
            return 0;

        max = Math.max(max, root.val);

        if (max <= root.val) {
            return 1 + dfs(root.left, max) + dfs(root.right, max);
        } else {
            return dfs(root.left, max) + dfs(root.right, max);
        }
    }
}