package tasks;

import java.util.Arrays;

public class ApplyOperationsToAnArray2460 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(applyOperations(new int[]{1, 2, 2, 1, 1, 0})));
    }

    public static int[] applyOperations(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }

        int nIndex = 0;

        for (int num : nums)
            if (num != 0)
                nums[nIndex++] = num;

        while (nIndex < nums.length)
            nums[nIndex++] = 0;

        return nums;
    }
}