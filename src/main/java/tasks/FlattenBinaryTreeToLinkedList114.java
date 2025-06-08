package tasks;

public class FlattenBinaryTreeToLinkedList114 {
    public static void main(String[] args) {

    }

    TreeNode c = new TreeNode(-1);
    TreeNode h = c;

    public void flatten(TreeNode root) {
        dfs(root);
        root = c.right;
    }

    private void dfs(TreeNode root) {
        if (root == null)
            return;

        this.h.right = new TreeNode(root.val);
        this.h = this.h.right;

        dfs(root.left);
        dfs(root.right);
    }
}