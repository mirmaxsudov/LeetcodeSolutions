package tasks;

public class MaximumSumWithExactlyKElements2656 {
    public static void main(String[] args) {

    }

    public static int maximizeSum(int[] nums, int k) {
        int max = 0;

        for (int num : nums)
            max = Math.max(num, max);

        return max + k;
    }
}