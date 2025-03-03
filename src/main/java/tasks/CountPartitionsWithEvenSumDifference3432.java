package tasks;

public class CountPartitionsWithEvenSumDifference3432 {
    public static void main(String[] args) {
        System.out.println(countPartitions(new int[]{10, 10, 3, 7, 6})); // 4
    }

    public static int countPartitions(int[] nums) {
        int left = nums[0];
        int right = 0;

        int res = 0;

        for (int i = 1; i < nums.length; i++)
            right += nums[i];

        for (int i = 1; i < nums.length ; i++) {
            if (Math.abs(left - right) % 2 == 0)
                res++;

            left += nums[i];
            right -= nums[i];
        }

        return res;
    }
}