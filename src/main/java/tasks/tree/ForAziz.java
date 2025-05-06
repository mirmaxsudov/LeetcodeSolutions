package tasks.tree;

import tasks.TreeNode;

public class ForAziz {
    public static void main(String[] args) {
//        TreeNode r1 = new TreeNode(1);
//        TreeNode r2 = new TreeNode(1, null, new TreeNode(2));
        // root1 = [1, 3, 2, 5]
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(5);

        // root2 = [2, 1, 3, null, 4, null, 7]
        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(3);
        root2.left.right = new TreeNode(4);
        root2.right.right = new TreeNode(7);

        ForAziz main = new ForAziz();

        TreeNode res = main.mergeTrees(root1, root2);

        showTree(res);
    }

    private static void showTree(TreeNode res) {
        if (res == null)
            return;

        System.out.print(res.val + " ");
        showTree(res.left);
        showTree(res.right);
    }

    TreeNode res;

    // d = Left 0 | Right 1;
    public TreeNode mergeTrees(TreeNode rt1, TreeNode rt2) {
        res = new TreeNode(-1);
        if (rt1 == null)
            return rt2;
        if (rt2 == null)
            return rt1;

        res.val = rt1.val + rt2.val;
        res.left = new TreeNode(0);
        res.right = new TreeNode(0);

        dfs(rt1.left, rt2.left, 0, res);
        dfs(rt1.right, rt2.right, 1, res);

        return res;
    }

    public void dfs(TreeNode r1, TreeNode r2, int d, TreeNode h) {
        if (r1 == null && r2 == null)
            return;

        if (r1 == null) {
            if (d == 0)
                h.left = r2;
            else
                h.right = r2;
            return;
        }

        if (r2 == null) {
            if (d == 0)
                h.left = r1;
            else
                h.right = r1;
            return;
        }

        int sum = r1.val + r2.val;

        if (d == 0)
            h.left = new TreeNode(sum);
        else
            h.right = new TreeNode(sum);

        dfs(r1.left, r2.left, 0, h.left);
        dfs(r1.right, r2.right, 1, h.right);
    }
}