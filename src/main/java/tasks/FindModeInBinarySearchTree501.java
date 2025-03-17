package tasks;

import java.util.*;

public class FindModeInBinarySearchTree501 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1); // val => 1, null, 2, 2
        root.right = new TreeNode(-3);
        root.right.left = new TreeNode(-3);

        FindModeInBinarySearchTree501 main = new FindModeInBinarySearchTree501();
        main.findMode(root);

    }

    private int curNum = 0;
    private int curCount = 0;
    private List<Integer> collector = new ArrayList<>();

    public int[] findModeVer2(TreeNode root) {
        return null;
    }

    private Map<Integer, Integer> mp = new TreeMap<>(
            Comparator.comparingInt(Integer::intValue).reversed()
    );
    private int max = 0;

    public int[] findMode(TreeNode root) {
        read(root);

        List<Integer> list = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            if (entry.getValue() == max)
                list.add(entry.getKey());
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    private void read(TreeNode root) {
        if (root == null)
            return;

        mp.put(root.val, mp.getOrDefault(root.val, 0) + 1);
        max = Math.max(max, mp.get(root.val));

        read(root.left);
        read(root.right);
    }
}