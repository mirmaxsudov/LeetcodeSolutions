package tasks;

import java.util.Arrays;

public class MinimizeMaximumPairSumInArray1877 {
    public static void main(String[] args) {

    }

    public static int minPairSum(int[] nums) {
        int res = 0;

        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;

        while (left < right)
            res = Math.max(res, nums[left--] + nums[right++]);

        return res;
    }
}