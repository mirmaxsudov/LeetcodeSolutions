package tasks;

public class DiameterOfBinaryTree543 {
    public static void main(String[] args) {
//        System.out.println(diameterOfBinaryTree(
//                new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3))
//        ));
//        System.out.println(
//                diameterOfBinaryTree(new TreeNode(1, new TreeNode(2), new TreeNode(3)))
//        );
//        System.out.println(
//                diameterOfBinaryTree(new TreeNode(1))
//        );
//        System.out.println(
//                diameterOfBinaryTree(new TreeNode(1, null, new TreeNode(2)))
//        );
    }

    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return max;
    }

    private void dfs(TreeNode root) {
        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            max = Math.max(max, 1);
            return;
        }

        if (root.left == null) {
            max = Math.max(max, 1 + findLen(root.right, 0));
        } else if (root.right == null) {
            max = Math.max(max, 1 + findLen(root.left, 0));
        } else {
            int sum = 1 + findLen(root.left, 0) + findLen(root.right, 0);
            max = Math.max(max, sum);
        }
    }

    private int findLen(TreeNode root, int len) {
        if (root == null)
            return len;

        return Math.max(findLen(root.left, len + 1), findLen(root.right, len + 1));
    }
}