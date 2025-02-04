package tasks;

public class LongestStrictlyIncreasingOrStrictlyDecreasingSubArray3105 {
    public static void main(String[] args) {
        System.out.println(longestMonotonicSubArray(new int[]{3, 3, 3, 3}));
        System.out.println(longestMonotonicSubArray(new int[]{1, 4, 3, 3, 2}));
    }

    public static int longestMonotonicSubArray(int[] nums) {
        int res = 1;

        if (nums.length == 1)
            return res;

        int i = 0, d = 0;

        for (int j = 0; j < nums.length - 1; j++) {
            if (nums[j] < nums[j + 1]) {
                i++;
                d = 1;
            } else if (nums[j] > nums[j + 1]) {
                d++;
                i = 1;
            } else {
                i = 1;
                d = 1;
            }

            res = Math.max(res, Math.max(i, d));
        }

        return res;
    }
}