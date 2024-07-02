package tasks;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class MinimumIncrementToMakeArrayUnique945 {
    public static void main(String[] args) {
        System.out.println(minIncrementForUnique(new int[]{3, 2, 1, 2, 1, 7}));
    }

    public static int minIncrementForUnique(int[] nums) {
        if (nums.length == 1)
            return 0;

        int minimum = 0;

        boolean[] isUsed = new boolean[nums.length];
        Set<Integer> uniqueNums = new LinkedHashSet<>();

        int m = getMinimumN(nums, isUsed, 1);

        return minimum;
    }

    private static int getMinimumN(int[] uniqueNums, boolean[] isUsed, int from) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int i = from; i < uniqueNums.length; i++) {
            if (!isUsed[i]) {
                if (uniqueNums[i] < min) {
                    min = uniqueNums[i];
                    minIndex = i;
                }
            }
        }

        isUsed[minIndex] = true;

        return min;
    }
}
