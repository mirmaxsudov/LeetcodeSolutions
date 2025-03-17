package tasks;

public class SubtreeOfAnotherTree572 {
    public static void main(String[] args) {

    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return dfs(root, subRoot);
    }

    private boolean dfs(TreeNode root, TreeNode subRoot) {
        if (root == null)
            return false;

        if (checkTreeIsSame(root, subRoot))
            return true;

        return dfs(root.left, subRoot) || dfs(root.right, subRoot);
    }

    private boolean checkTreeIsSame(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null)
            return true;

        if (root == null || subRoot == null)
            return false;

        if (root.val != subRoot.val)
            return false;

        if (root.right != null && subRoot.right == null)
            return false;

        if (root.left != null && subRoot.left == null)
            return false;

        return checkTreeIsSame(root.left, subRoot.left) && checkTreeIsSame(root.right, subRoot.right);
    }
}