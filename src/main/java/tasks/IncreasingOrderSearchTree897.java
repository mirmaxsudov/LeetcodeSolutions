package tasks;


public class IncreasingOrderSearchTree897 {
    public static void main(String[] args) {

    }

    TreeNode res = null;

    public TreeNode increasingBST(TreeNode root) {
        inOrder(root);
        return res.right;
    }

    private void inOrder(TreeNode root) {
        if (root == null)
            return;

        inOrder(root.left);
        res = new TreeNode(root.val, null, res);
        inOrder(root.right);
    }
}