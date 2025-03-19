package tasks;

public class FindBottomLeftTreeValue513 {
    public static void main(String[] args) {

    }

    private int leftValue;
    private int deepestValue;
    private int deepestLevel;
    private int level;

    public int findBottomLeftValue(TreeNode root) {
        leftValue = -1;
        level = -1;
        deepestValue = -1;
        deepestLevel = -1;

        dfs(root, 1, 0);
        return leftValue == -1 ? deepestValue : leftValue;
    }

    private void dfs(TreeNode root, int type, int level) {
        if (root == null)
            return;

        if (type == 0 && level > this.level)
            leftValue = root.val;

        if (level > deepestLevel)
            deepestValue = root.val;

        dfs(root.left, 0, level + 1);
        dfs(root.right, 1, level + 1);
    }
}