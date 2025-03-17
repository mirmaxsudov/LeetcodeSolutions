package tasks;

import java.util.ArrayList;
import java.util.List;

public class MinimumDistanceBetweenBSTNodes783 {
    public static void main(String[] args) {

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