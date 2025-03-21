package tasks.tree;


import tasks.TreeNode;

public class CountNodesEqualToAverageOfSubtree2265 {
    public static void main(String[] args) {

    }

    public int averageOfSubtree(TreeNode root) {
        int[] res = new int[1];
        dfs(root, res);
        return res[0];
    }

    private int[] dfs(TreeNode root, int[] res) {
        if (root == null)
            return new int[]{0, 0};

        int[] left = dfs(root.left, res);
        int[] right = dfs(root.right, res);

        int sum = left[0] + right[0] + root.val;
        int count = left[1] + right[1] + 1;

        if (sum / count == root.val)
            res[0]++;

        return new int[]{sum, count};
    }
}