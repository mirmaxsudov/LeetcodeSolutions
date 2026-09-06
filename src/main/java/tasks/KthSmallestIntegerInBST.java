package tasks;

public class KthSmallestIntegerInBST {
    public static void main(String[] args) {
        KthSmallestIntegerInBST main = new KthSmallestIntegerInBST();
        System.out.println(main.kthSmallest(new TreeNode(3, new TreeNode(1, null, new TreeNode(2)), new TreeNode(4)), 1));
        System.out.println(main.kthSmallest(
                new TreeNode(4, new TreeNode(3, new TreeNode(2), null), new TreeNode(5)), 4));
    }

    public int kthSmallest(TreeNode root, int k) {
        int[] res = dfs(root, k);
        return res[0];
    }

    public int[] dfs(TreeNode root, int k) {
        if (root == null)
            return new int[]{10001, k};

        if (k == 0)
            return new int[]{root.val, 0};

        int[] leftRes = dfs(root.left, k - 1);

        if (leftRes[1] == 0)
            return leftRes;

        if (root.right == null)
            return leftRes;

        int[] rightRes = dfs(root.right, leftRes[1] - 1);

        if (rightRes[1] == 0)
            return rightRes;

        return new int[]{
                // Math.min(leftRes[0], rightRes[0]),
                // Math.min(leftRes[1], rightRes[1])
                -1, -1
        };
    }
}