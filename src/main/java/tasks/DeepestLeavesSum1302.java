package tasks;

import java.util.HashMap;
import java.util.Map;

public class DeepestLeavesSum1302 {
    public static void main(String[] args) {

    }

    private final Map<Integer, Integer> mp = new HashMap<>();
    private int maxLevel = 0;

    public int deepestLeavesSum(TreeNode root) {
        dfs(0, root);
        return mp.get(maxLevel);
    }

    public void dfs(int level, TreeNode root) {
        if (root == null)
            return;

        if (!mp.containsKey(level))
            mp.put(level, 0);

        mp.put(level, mp.get(level) + root.val);

        dfs(level + 1, root.left);
        dfs(level + 1, root.right);
        maxLevel = Math.max(maxLevel, level);
    }
}