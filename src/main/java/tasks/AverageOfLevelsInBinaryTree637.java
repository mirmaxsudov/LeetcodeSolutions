package tasks;

import java.util.*;

public class AverageOfLevelsInBinaryTree637 {
    public static void main(String[] args) {

    }

    private Map<Integer, List<Integer>> mp = new HashMap<>();

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> averages = new LinkedList<>();

        dfs(0, root);

        for (Map.Entry<Integer, List<Integer>> entry : mp.entrySet()) {
            List<Integer> list = entry.getValue();

            double sum = 0;

            for (int num : list)
                sum += num;

            averages.add(sum / list.size());
        }

        return averages;
    }

    public void dfs(int level, TreeNode root) {
        if (root == null)
            return;

        if (!mp.containsKey(level))
            mp.put(level, new ArrayList<>());

        mp.get(level).add(root.val);

        dfs(level + 1, root.left);
        dfs(level + 1, root.right);
    }
}