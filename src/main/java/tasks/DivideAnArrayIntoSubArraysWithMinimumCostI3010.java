package tasks;

public class DivideAnArrayIntoSubArraysWithMinimumCostI3010 {
    public static void main(String[] args) {
        System.out.println(minimumCost(new int[]{10, 5, 50, 1, 5, 10, 9}));
    }

    public static int minimumCost(int[] nums) {
        int len = nums.length;

        if (len == 3)
            return nums[0] + nums[1] + nums[2];

        int preview = nums[0];
        int sum = preview;

        for (int i = 1; i < nums.length; i++) {
            if (preview > nums[i]) {
                sum += nums[i];
                preview = nums[i];
            }
        }

        return sum;
    }
}