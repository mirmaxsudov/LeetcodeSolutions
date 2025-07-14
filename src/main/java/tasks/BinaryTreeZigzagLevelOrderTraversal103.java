package tasks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BinaryTreeZigzagLevelOrderTraversal103 {
    public static void main(String[] args) {

    }


    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(List.of(root.val));

        List<TreeNode> roots = new ArrayList<>();
        roots.add(root);
        boolean isRight = false;

        while (!roots.isEmpty()) {
            List<TreeNode> helper = new ArrayList<>();
            List<Integer> vals = new ArrayList<>();

            if (isRight) {
                for (TreeNode node : roots) {
                    if (node.left != null)
                        helper.add(node.left);
                    if (node.right != null)
                        helper.add(node.right);
                    vals.add(node.val);
                }
            } else {
                for (int i = roots.size() - 1; i >= 0; i--) {
                    TreeNode node = roots.get(i);
                    if (node.right != null)
                        helper.add(node.right);
                    if (node.left != null)
                        helper.add(node.left);
                    vals.add(node.val);
                }
            }
            roots.clear();
            roots = helper;
            list.add(vals);
            isRight = !isRight;
        }

        return list;
    }
}
