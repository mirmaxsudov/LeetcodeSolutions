package tasks;

public class UnivaluedBinaryTree965 {
    public static void main(String[] args) {

    }

    public static boolean isUnivalTree(TreeNode root) {
        return helper(root.val, root.left) && helper(root.val, root.right);
    }

    private static boolean helper(int prevVal, TreeNode root) {
        if (root == null)
            return true;

        if (prevVal != root.val)
            return false;

        return helper(root.val, root.left) && helper(root.val, root.right);
    }
}