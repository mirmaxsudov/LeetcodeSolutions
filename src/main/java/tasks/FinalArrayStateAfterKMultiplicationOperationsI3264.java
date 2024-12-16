package tasks;

import java.util.Arrays;

public class FinalArrayStateAfterKMultiplicationOperationsI3264 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getFinalState(new int[]{1, 2, 3, 4}, 2, 3)));
    }

    public static int[] getFinalState(int[] nums, int k, int multiplier) {
        for (int i = 0; i < k; i++) {
            int min = Integer.MAX_VALUE;
            int index = -1;

            for (int j = 0; j < nums.length; j++)
                if (nums[j] < min) {
                    min = nums[j];
                    index = j;
                }

            if (index != -1)
                nums[index] *= multiplier;
        }

        return nums;
    }
}