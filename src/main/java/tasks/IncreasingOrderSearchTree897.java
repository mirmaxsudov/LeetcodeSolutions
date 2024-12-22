package tasks;


public class IncreasingOrderSearchTree897 {
    public static void main(String[] args) {

    }

    public static TreeNode increasingBST(TreeNode root) {
        TreeNode res = new TreeNode();
        inOrder(root, res);
        return res;
    }

    private static void inOrder(TreeNode root, TreeNode temp) {
        if (root == null)
            return;

        inOrder(root.left, temp);
        temp.right = new TreeNode(root.val);
        temp = temp.right;
        inOrder(root.right, temp);
    }
}