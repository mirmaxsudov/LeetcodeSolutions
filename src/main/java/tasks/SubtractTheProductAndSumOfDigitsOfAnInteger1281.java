package tasks;

public class SubtractTheProductAndSumOfDigitsOfAnInteger1281 {
    public static void main(String[] args) {
        System.out.println(subtractProductAndSum(234));
    }

    public static int subtractProductAndSum(int n) {
        return solve(n, 0, 1);
    }

    private static int solve(int n, int s, int m) {
        if (n == 0)
            return m - s;

        return solve(n / 10, s + (n % 10), m * (n % 10));
    }
}