package tasks;

public class DiameterOfBinaryTree543 {
    public static void main(String[] args) {
        System.out.println(diameterOfBinaryTree(
                new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3))
        ));
        System.out.println(
                diameterOfBinaryTree(new TreeNode(1, new TreeNode(2), new TreeNode(3)))
        );
        System.out.println(
                diameterOfBinaryTree(new TreeNode(1))
        );
        System.out.println(
                diameterOfBinaryTree(new TreeNode(1, null, new TreeNode(2)))
        );
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        int leftLen = findLen(root.left, 1);
        int rightLen = findLen(root.right, 1);

        System.out.println("rightLen = " + rightLen);
        System.out.println("leftLen = " + leftLen);

        return Math.max(leftLen, rightLen) + 1;
    }

    public static int findLen(TreeNode root, int len) {
        if (root == null)
            return len;

        return Math.max(findLen(root.left, len + 1), findLen(root.right, len + 1));
    }
}