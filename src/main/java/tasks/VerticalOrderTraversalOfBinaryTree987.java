package tasks;

import java.util.*;

public class VerticalOrderTraversalOfBinaryTree987 {
    public static void main(String[] args) {

    }

    Map<Integer, List<int[]>> mp = new TreeMap<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        readValues(root, 0, 0);

        mp.forEach((dir, list) -> {
            ;
            list.sort((a, b) -> {
                if (a[1] == b[1])
                    return a[0] - b[0];
                return a[1] - b[1];
            });
        });

        for (Map.Entry<Integer, List<int[]>> integerListEntry : mp.entrySet()) {
            System.out.println("integerListEntry = " + integerListEntry.getKey());
            for (int[] ints : integerListEntry.getValue()) {
                System.out.println("ints = " + Arrays.toString(ints));
            }
        }

        for (Map.Entry<Integer, List<int[]>> en : mp.entrySet())
            res.add(en.getValue().stream().map(a -> a[0]).toList());

        return res;
    }

    public void readValues(TreeNode root, int depth, int dir) {
        if (root == null)
            return;

        readValues(root.left, depth + 1, dir - 1);
        mp.putIfAbsent(dir, new ArrayList<>());
        mp.get(dir).add(new int[]{root.val, depth, dir});
        readValues(root.right, depth + 1, dir + 1);
    }
}