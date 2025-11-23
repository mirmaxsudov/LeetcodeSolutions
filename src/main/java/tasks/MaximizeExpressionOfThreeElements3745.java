package tasks;

public class MaximizeExpressionOfThreeElements3745 {
    public static void main(String[] args) {
        System.out.println(maximizeExpressionOfThree(new int[]{-2, 0, 5, -2, 4}));
    }

    public static int maximizeExpressionOfThree(int[] nums) {
        int max1 = Math.max(nums[0], nums[1]), max2 = Math.min(nums[0], nums[1]), min = Math.min(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] >= max1) {
                max2 = max1;
                max1 = nums[i];
            } else if (nums[i] > max2)
                max2 = nums[i];

            min = Math.min(min, nums[i]);
        }

        return max1 + max2 - min;
    }
}
