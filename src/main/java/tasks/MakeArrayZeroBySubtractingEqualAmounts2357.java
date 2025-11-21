package tasks;

import java.util.Arrays;

public class MakeArrayZeroBySubtractingEqualAmounts2357 {
    public static void main(String[] args) {
        System.out.println(minimumOperations(new int[]{1, 5, 0, 3, 5}));
        System.out.println(minimumOperations(new int[]{0}));
        System.out.println(minimumOperations(new int[]{1, 2, 3, 5}));
    }

    public static int minimumOperations(int[] nums) {
        int min = 0;

        if (nums.length == 1)
            return nums[0] == 0 ? 0 : 1;

        Arrays.sort(nums);

        int minNum = nums[0];
        int index = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                continue;

            minNum = nums[i];
            index = i;
            break;
        }

        if (index == -1)
            return 0;

        while (true) {
            int newMinNum = -1;
            int newIndex = -1;
            for (int i = index; i < nums.length; i++) {
                nums[i] -= minNum;
                if (newMinNum == -1 && nums[i] != 0) {
                    newMinNum = nums[i];
                    newIndex = i;
                }
            }

            if (newMinNum == -1)
                return min + 1;
            minNum = newMinNum;
            index = newIndex;
            min++;
        }
    }
}