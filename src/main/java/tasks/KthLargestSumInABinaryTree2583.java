package tasks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class KthLargestSumInABinaryTree2583 {
    public static void main(String[] args) {

    }

    public long kthLargestLevelSum(TreeNode root, int k) {
        List<Long> list = new ArrayList<>();

        List<TreeNode> c = new ArrayList<>();
        c.add(root);

        while (!c.isEmpty()) {
            List<TreeNode> helper = new ArrayList<>();
            long sum = 0;

            for (TreeNode treeNode : c) {
                if (treeNode.left != null)
                    helper.add(treeNode.left);
                if (treeNode.right != null)
                    helper.add(treeNode.right);
                sum += treeNode.val;
            }

            list.add(sum);
            c.clear();
            c.addAll(helper);
        }

        if (list.size() < k)
            return -1;

        list.sort(Comparator.reverseOrder());

        return list.get(k - 1);
    }
}