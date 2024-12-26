package tasks;

import java.util.Arrays;

public class RotateArray189 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        rotate(arr, 3); // 5, 6, 7, 1, 2, 3, 4
        System.out.println(Arrays.toString(arr));
    }

    public static void rotate(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            int t = nums[i];
            nums[i] = nums[nums.length - k - i];
            nums[nums.length - k - i] = t;
        }
    }
}