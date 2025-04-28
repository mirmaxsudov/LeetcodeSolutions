package tasks;

import java.util.Arrays;

public class FindIndicesWithIndexAndValueDifferenceI2903 {
    public static void main(String[] args) {

    }

    public static int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (Math.abs(i - j) == indexDifference && Math.abs(nums[i] - nums[j]) == valueDifference) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{-1, -1};
    }
}