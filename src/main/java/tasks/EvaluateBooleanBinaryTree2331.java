package tasks;

public class EvaluateBooleanBinaryTree2331 {
    public static void main(String[] args) {

    }

    public static boolean evaluateTree(TreeNode root) {
        if (root.val == 1 || root.val == 0)
            return root.val == 1;

        if (root.val == 2)
            return evaluateTree(root.left) || evaluateTree(root.right);
        else
            return evaluateTree(root.left) && evaluateTree(root.right);
    }
}