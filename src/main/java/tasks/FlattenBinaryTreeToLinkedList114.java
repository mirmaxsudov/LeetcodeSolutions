package tasks;

public class FlattenBinaryTreeToLinkedList114 {
    public static void main(String[] args) {

    }

    private TreeNode res = new TreeNode(-1);
    private TreeNode current;

    public void flatten(TreeNode root) {
        current = res;
        inOrder(root);

        root = res.right;
    }

    private void inOrder(TreeNode root) {
        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            current.right = new TreeNode(root.val);
            current = current.right;
            return;
        }

        inOrder(root.left);
        inOrder(root.right);
    }
}