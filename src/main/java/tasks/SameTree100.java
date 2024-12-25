package tasks;

public class SameTree100 {
    public static void main(String[] args) {

    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;

        if (p == null || q == null)
            return false;

        if (p.val != q.val)
            return false;

        return dfs(p.left, q.left) && dfs(p.right, q.right);
    }

    private static boolean dfs(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;

        if (p == null || q == null)
            return false;

        if (p.val != q.val)
            return false;

        return dfs(p.left, q.left) && dfs(p.right, q.right);
    }
}
