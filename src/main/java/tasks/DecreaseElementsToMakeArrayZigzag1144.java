package tasks;

import java.awt.color.ICC_ColorSpace;

public class DecreaseElementsToMakeArrayZigzag1144 {
    public static void main(String[] args) {

    }

    public static int movesToMakeZigzag(int[] nums) {
        int evenCount, oddCount;
        evenCount = oddCount = 0;

        // For even
        for (int i = 0; i < nums.length - 2; i++) {
            int minNum = Math.min(nums[i], nums[i + 2]);
            evenCount += minNum - nums[i + 1];
            i++;
        }

        if (nums.length % 2 == 0)
            evenCount += nums[nums.length - 1] - nums[nums.length - 2];

        // For odd
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i - 1] > nums[i])
                oddCount += nums[i - 1] - nums[i] - 1;
            if (nums[i + 1] > nums[i])
                oddCount += nums[i + 1] - nums[i] - 1;
            i++;
        }

        if (nums.length % 2 == 1 && nums[nums.length - 2] > nums[nums.length - 1])
            evenCount += nums[nums.length - 2] - nums[nums.length - 1] - 1;

        return Math.min(evenCount, oddCount);
    }
}