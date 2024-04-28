package tasks;

import java.util.ArrayList;
import java.util.List;

public class SumOfRootLeafNumber129 {
    public static void main(String[] args) {

    }

    public static final List<String> leaves = new ArrayList<>();

    public static int sumNumbers(TreeNode root) {
        StringBuilder leaf = new StringBuilder();

        if (root.left == null && root.right == null) {
            return sum();
        }

        leaf.append(root.val);

        if (root.left != null) {
            leaf.append(sumNumbers(root.left));
        }

        if (root.right != null) {
            leaf.append(sumNumbers(root.right));
        }

        if (root.left == null && root.right == null) {
            leaves.add(leaf.toString());
            return Integer.parseInt(leaf.toString());
        }

        return 0;
    }

    private static int sum() {
        int sum = 0;

        for (String leaf : SumOfRootLeafNumber129.leaves)
            sum += Integer.parseInt(leaf);

        return sum;
    }
}