package tasks;

public class AmountOfTimeForBinaryTreeToBeInfected2385 {
    public static void main(String[] args) {

    }

    public int amountOfTime(TreeNode root, int start) {
        if (root.val == start)
            return maxDepth(root, 0);


        return 0;
    }

    private int maxDepth(TreeNode root, int depth) {
        if (root == null)
            return depth;

        return Math.max(maxDepth(root.left, depth + 1), maxDepth(root.right, depth + 1));
    }
}
