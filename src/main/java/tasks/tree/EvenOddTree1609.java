package tasks.tree;

import tasks.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class EvenOddTree1609 {
    public static void main(String[] args) {

    }

    public boolean isEvenOddTree(TreeNode root) {
        int d = 0; // 0 - even, 1 - odd
        List<TreeNode> list = new ArrayList<>();
        list.add(root);

        while (!list.isEmpty()) {
            List<TreeNode> children = new ArrayList<>();
            int val = list.getFirst().val;

            if (d % 2 == 0) {
                if (val % 2 == 0)
                    return false;
            } else {
                if (val % 2 == 1)
                    return false;
            }

            for (int i = 1; i < list.size(); i++) {
                if (d % 2 == 0) {
                    if (val >= list.get(i).val || val % 2 == 0)
                        return false;
                } else {
                    if (val <= list.get(i).val || val % 2 == 1)
                        return false;
                }
                val = list.get(i).val;
            }

            for (TreeNode node : list) {
                if (node.left != null)
                    children.add(node.left);
                if (node.right != null)
                    children.add(node.right);
            }

            list.clear();
            list = children;
            d = d == 0 ? 1 : 0;
        }

        return true;
    }
}