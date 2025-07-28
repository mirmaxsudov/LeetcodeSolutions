package tasks.tree;

import tasks.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSumII113 {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, res, targetSum, new ArrayList<>());
        return res;
    }

    private static void dfs(TreeNode root, List<List<Integer>> res, int sum, ArrayList<Integer> vals) {
        if (root == null)
            return;

        sum -= root.val;
        vals.add(root.val);

        if (root.left == null && root.right == null && sum == 0)
            res.add(new ArrayList<>(vals));
        else {
            dfs(root.left, res, sum, vals);
            dfs(root.right, res, sum, vals);
        }

        vals.removeLast();
    }
}