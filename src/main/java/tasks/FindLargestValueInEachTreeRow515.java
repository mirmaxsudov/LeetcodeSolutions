package tasks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindLargestValueInEachTreeRow515 {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(
                1,
                new TreeNode(3, new TreeNode(5), new TreeNode(3)),
                new TreeNode(2, null, new TreeNode(9))
        );

        System.out.println(largestValues2(tree));
    }

    public static List<Integer> largestValues2(TreeNode root) {
        Map<Integer, Integer> mp = new HashMap<>();

        List<Integer> res = new ArrayList<>();

        taker(root, 0, mp);

        for (Map.Entry<Integer, Integer> en : mp.entrySet())
            res.add(en.getValue());

        return res;
    }

    private static void taker(TreeNode root, int level, Map<Integer, Integer> mp) {
        if (root == null)
            return;

        int lT = mp.getOrDefault(level, Integer.MIN_VALUE);

        if (lT == -1)
            mp.put(level, root.val);

        mp.put(level, Math.max(root.val, lT));

        taker(root.left, level + 1, mp);
        taker(root.right, level + 1, mp);
    }

    public static List<Integer> largestValues(TreeNode root) {
        List<TreeNode> nodes = new ArrayList<>();
        List<Integer> res = new ArrayList<>();

        nodes.add(root);

        while (root != null && !nodes.isEmpty()) {
            List<TreeNode> temp = new ArrayList<>();
            int max = Integer.MIN_VALUE;

            for (TreeNode node : nodes) {
                max = Math.max(node.val, max);

                if (node.left != null) {
                    temp.add(node.left);
                }

                if (node.right != null) {
                    temp.add(node.right);
                }
            }

            res.add(max);
            nodes = temp;
        }

        return res;
    }
}