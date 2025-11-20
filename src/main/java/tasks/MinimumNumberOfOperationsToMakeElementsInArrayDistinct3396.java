package tasks;

import java.util.HashMap;
import java.util.Map;

public class MinimumNumberOfOperationsToMakeElementsInArrayDistinct3396 {
    public static void main(String[] args) {
        System.out.println(minimumOperations(new int[]{1, 2, 3, 4, 2, 3, 3, 5, 7}));
    }

    public static int minimumOperations(int[] nums) {
        int duplicateCount = 0;
        int count = 0;

        Map<Integer, Integer> mp = new HashMap<>();

        for (int num : nums)
            if (mp.put(num, mp.getOrDefault(num, 0) + 1) != null)
                duplicateCount++;

        if (duplicateCount == 0)
            return 0;

        if (duplicateCount > 0 && nums.length <= 3)
            return 1;

        for (int i = 0; i < nums.length; i += 3) {
            if (duplicateCount == 0)
                break;

            if (nums.length - i <= 3)
                return count + 1;

            for (int j = i; j < i + 3; j++) {
                int numCount = mp.get(nums[j]);

                if (numCount > 1) {
                    mp.put(nums[j], numCount - 1);
                    duplicateCount--;
                }
            }

            count++;
        }

        return count;
    }
}
