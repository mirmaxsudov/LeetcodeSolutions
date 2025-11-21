package tasks;

public class StepByStepDirectionsFromABinaryTreeNodeToAnother2096 {
    public static void main(String[] args) {

    }

    StringBuilder sb = new StringBuilder();

    public String getDirections(TreeNode root, int startValue, int destValue) {
        dfs(root, startValue, destValue);

        return sb.toString();
    }

    private String dfs(TreeNode root, int startValue, int destValue) {
        if (root == null)
            return null;

        String leftPath = dfs(root.left, startValue);
        String rightPath = dfs(root.right, destValue);

        return null;
    }

    private String dfs(TreeNode left, int val) {
        return null;
    }
}
