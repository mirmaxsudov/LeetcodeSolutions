package tasks;

public class BinaryTreeTilt563 {
    public static void main(String[] args) {

    }

    public static int findTilt(TreeNode root) {
        return dfs(root);
    }

    private static int dfs(TreeNode root) {
        if (root == null)
            return 0;

        if (root.left == null && root.right == null)
            return root.val;

        int leftSum = dfs(root.left);
        int rightSum = dfs(root.right);

        int tilt = Math.abs(leftSum - rightSum);

        return tilt + leftSum + rightSum;
    }
}