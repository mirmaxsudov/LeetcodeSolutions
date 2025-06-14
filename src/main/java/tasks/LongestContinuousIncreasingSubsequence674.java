package tasks;

public class LongestContinuousIncreasingSubsequence674 {
    public static void main(String[] args) {

    }

    public static int findLengthOfLCIS(int[] nums) {
        int max = 0;
        int c = 0;

        for (int i = nums.length - 1; i >= 1; i--)
            if (nums[i] < nums[i - 1])
                c++;
            else {
                max = Math.max(max, c);
                c = 0;
            }

        return max;
    }
}