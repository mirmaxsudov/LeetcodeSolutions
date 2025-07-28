package tasks;

public class LongestZigZagPathInABinaryTree1372 {
    public static void main(String[] args) {

    }

    public int longestZigZag(TreeNode root) {
        return Math.max(
                dfs(root, 0, 0),
                dfs(root, 1, 0)
        );
    }

    public int dfs(TreeNode root, int direction, int depth) {
        if (root == null)
            return depth;

        if (direction == 0) {
            return Math.max(
                    dfs(root.left, 1, depth + 1),
                    dfs(root.right, 0, 0)
            );
        } else {
            return Math.max(
                    dfs(root.right, 0, depth + 1),
                    dfs(root.left, 1, 0)
            );
        }
    }
}