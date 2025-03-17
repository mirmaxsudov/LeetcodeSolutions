package tasks;

import java.util.ArrayList;
import java.util.List;

public class MinimumDistanceBetweenBSTNodes783 {
    public static void main(String[] args) {

    }

    private int min = Integer.MAX_VALUE;

    public int minDiffInBSTVer2(TreeNode root) {
        dfs(root.left, root.val);
        dfs(root.right, root.val);

        return min;
    }

    private void dfs(TreeNode root, int val) {
        if (root == null)
            return;

        dfs(root.left, root.val);
        min = Math.min(min, val - root.val);
        dfs(root.right, root.val);
    }

    private List<Integer> list = new ArrayList<>();

    public int minDiffInBST(TreeNode root) {
        dfs(root);

        if (list.size() >= 2) {
            int min = Integer.MAX_VALUE;

            for (int i = 1; i < list.size(); i++)
                min = Math.min(min, list.get(i) - list.get(i - 1));

            return min;
        }

        return -1;
    }

    private void dfs(TreeNode root) {
        if (root == null)
            return;

        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }
}