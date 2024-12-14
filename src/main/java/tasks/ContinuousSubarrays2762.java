package tasks;

import java.util.Arrays;

public class ContinuousSubarrays2762 {
    public static void main(String[] args) {
        System.out.println(continuousSubArrays(new int[]{5, 4, 2, 4}));
        System.out.println(continuousSubArrays(new int[]{1, 2, 3}));
    }

    public static long continuousSubArrays(int[] nums) {
        int count = 0;
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i; j += 1) {
                int max = Integer.MIN_VALUE;
                int min = Integer.MAX_VALUE;

                for (int k = j; k < j + i + 1; k++) {
                    max = Math.max(max, nums[k]);
                    min = Math.min(min, nums[k]);
                }

                if (Math.abs(min - max) <= 2) {
                    count++;
                }
            }
        }

        return count;
    }
}