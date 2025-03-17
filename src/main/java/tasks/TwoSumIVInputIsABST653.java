package tasks;

import java.util.ArrayList;
import java.util.List;

public class TwoSumIVInputIsABST653 {
    public static void main(String[] args) {

    }

    private List<Integer> list = new ArrayList<>();

    public boolean findTarget(TreeNode root, int k) {
        read(root);

        int left = 0;
        int right = list.size() - 1;

        while (left < right) {
            int sum = list.get(left) + list.get(right);
            if (sum == k)
                return true;

            if (sum > k) {
                right--;
            } else {
                left++;
            }
        }

        return false;
    }

    private void read(TreeNode root) {
        if (root == null)
            return;

        read(root.left);
        list.add(root.val);
        read(root.right);
    }
}