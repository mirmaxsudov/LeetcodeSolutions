package tasks;

public class ReverseOddLevelsOfBinaryTree2415 {
    public static void main(String[] args) {
    }

    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null)
            return null;

        bfs(root.left, root.right, 0);

        return root;
    }

    private void bfs(TreeNode left, TreeNode right, int level) {
        if (left == null || right == null)
            return;

        if ((level & 1) == 0) {
            int lVal = left.val;
            left.val = right.val;
            right.val = lVal;
        }

        bfs(left.left, right.right, level + 1);
        bfs(left.right, right.left, level + 1);
    }
}