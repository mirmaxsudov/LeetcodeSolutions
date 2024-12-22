package tasks;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal94 {
    public static void main(String[] args) {

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        return null;
    }

    private void inOrder(TreeNode root, List<Integer> list) {
        if (root == null)
            return;

        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }

    public static double getProbability(int[] balls) {
        int n = 0;
        for (int ball : balls) {
            n += ball;
        }
        n = n / 2;
        double total = 1;
        for (int ball : balls) {
            total *= comb(ball, n);
        }
        total /= Math.pow(2, n);
        return total;
    }

    private static double comb(int n, int k) {
        double res = 1;
        for (int i = 1; i <= k; i++) {
            res = res * (n - i + 1) / i;
        }
        return res;
    }


}