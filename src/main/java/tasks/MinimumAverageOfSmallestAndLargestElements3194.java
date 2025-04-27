package tasks;

import java.util.Arrays;

public class MinimumAverageOfSmallestAndLargestElements3194 {
    public static void main(String[] args) {

    }

    public static double minimumAverage(int[] nums) {
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1;
        double res = Double.MAX_VALUE;

        while (l < r) {
            res = Math.min(res, (nums[l] + nums[r]) / 2d);
            l++;
            r--;
        }

        return res;
    }
}