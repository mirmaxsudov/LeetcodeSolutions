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

        int sum = 0;

        for (int num : nums)
            if (num > 0)
                sum += num;

        int i = 0;

        while (k > 0) {
            if (nums[i] >= 0)
                break;

            sum += (nums[i] * -1);
            i++;
            k--;
        }

        if (nums[i] == 0)
            return sum;

        return sum;
    }
}