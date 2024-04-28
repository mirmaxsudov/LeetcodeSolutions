package tasks;

public class AddOneRowToTree623 {
    public static void main(String[] args) {

    }

    public TreeNode helper(TreeNode root, int val, int depth, int current) {
        if (depth == 1)
            return new TreeNode(val, root, null);

        if (root == null)
            return null;

        if (current == depth - 1) {
            TreeNode leftMan = root.left;
            TreeNode rightMan = root.right;

            root.left = new TreeNode(val);
            root.right = new TreeNode(val);

            root.left.left = leftMan;
            root.right.right = rightMan;
            return root;

        }

        helper(root.left, val, depth, current + 1);
        helper(root.right, val, depth, current + 1);

        return root;

    }

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        return helper(root, val, depth, 1);
    }
}
