package tasks;

import java.util.Arrays;

public class MaximumBeautyOfAnArrayAfterApplyingOperation2779 {
    public static void main(String[] args) {
        System.out.println(maximumBeauty(new int[]{4, 6, 1, 2}, 2));
    }

    public static int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);

        int max = 0, right = 1;

        int len = nums.length;

        for (int i = 0; i < len; i++) {
            while (right < len && nums[right] - nums[i] <= k * 2) {
                right++;
            }

            max = Math.max(right - i, max);
        }

        return max;
    }
}