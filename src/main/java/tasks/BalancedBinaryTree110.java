package tasks;

public class BalancedBinaryTree110 {
    public static void main(String[] args) {
        System.out.println(isBalanced(new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)))));
    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;


        return isBalanced(root.left) && isBalanced(root.right) && Math.abs(height(root.left) - height(root.right)) <= 1;
    }

    private static int height(TreeNode left) {
        if (left == null)
            return 0;
        return Math.max(height(left.left), height(left.right)) + 1;
    }
}
