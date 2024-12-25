package tasks;

import java.util.ArrayList;
import java.util.List;

public class FindLargestValueInEachTreeRow515 {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(
                1,
                new TreeNode(3, new TreeNode(5), new TreeNode(3)),
                new TreeNode(2, null, new TreeNode(9))
        );

        System.out.println(largestValues(tree));
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