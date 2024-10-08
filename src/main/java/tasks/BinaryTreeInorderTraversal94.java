package tasks;

public class BinaryTreeInorderTraversal94 {
    public static void main(String[] args) {

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