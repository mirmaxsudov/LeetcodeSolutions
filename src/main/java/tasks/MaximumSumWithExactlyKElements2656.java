package tasks;

public class MaximumSumWithExactlyKElements2656 {
    public static void main(String[] args) {

    }

    public static int maximizeSum(int[] nums, int k) {
        int m = 0;

        for (int num : nums)
            m = Math.max(m, num);

        return m * k + (k * (k - 1) / 2);
    }
}