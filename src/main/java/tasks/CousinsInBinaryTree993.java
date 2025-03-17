package tasks;

public class CousinsInBinaryTree993 {
    public static void main(String[] args) {
        // [1,2,3,null,null,4,5]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(5);

        CousinsInBinaryTree993 main = new CousinsInBinaryTree993();
        System.out.println(main.isCousins(root, 4, 5));
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        int[] xLevel = findLevelByValue(root, x, 0, -1);
        int[] yLevel = findLevelByValue(root, y, 0, -1);

        if (xLevel[0] == -1 || yLevel[0] == -1)
            return false;

        if (xLevel[1] == -1 || yLevel[1] == -1)
            return false;

        if (xLevel[0] == yLevel[0])
            return xLevel[0] >= 2 && xLevel[1] != yLevel[1];

        return false;
    }

    private int[] findLevelByValue(TreeNode root, int value, int level, int parentVal) {
        if (root == null)
            return new int[]{-1, -1};

        if (root.val == value)
            return new int[]{level, parentVal};

        int[] leftLevel = findLevelByValue(root.left, value, level + 1, root.val);

        if (leftLevel[0] != -1)
            return leftLevel;

        return findLevelByValue(root.right, value, level + 1, root.val);
    }
}