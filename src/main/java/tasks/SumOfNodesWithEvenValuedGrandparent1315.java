package tasks;

public class SumOfNodesWithEvenValuedGrandparent1315 {
    public static void main(String[] args) {

    }

    public int sumEvenGrandparent(TreeNode root) {
        return dfs(root, null, null);
    }

    public int dfs(TreeNode root, TreeNode p, TreeNode gp) {
        if (root == null) return 0;
        if (p == null)
            return dfs(root.left, root, null) + dfs(root.right, root, null);
        return (gp != null && gp.val % 2 == 0 ? root.val : 0) + dfs(root.left, root, p) + dfs(root.right, root, p);
    }
}
