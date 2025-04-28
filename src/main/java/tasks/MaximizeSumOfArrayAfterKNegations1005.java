package tasks;

import java.util.Arrays;

public class MaximizeSumOfArrayAfterKNegations1005 {
    public static void main(String[] args) {
//        System.out.println(largestSumAfterKNegations(new int[]{4, 2, 3}, 1));
//        System.out.println(largestSumAfterKNegations(new int[]{3, -1, 0, 2}, 3));
        System.out.println(largestSumAfterKNegations(new int[]{2, -3, -1, 5, -4}, 2));
    }

    public static int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                break;

            if (nums[i] == 0 || k == 0) {
                k = 0;
                break;
            }

            nums[i] *= -1;
            k--;
        }

        if (k != 0) {
            int min = Integer.MAX_VALUE;
            int index = -1;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] < min) {
                    min = nums[i];
                    index = i;
                }
            }

            if (k % 2 != 0)
                nums[index] *= -1;
        }

        int sum = 0;

        for (int num : nums)
            sum += num;

        return sum;
    }
}