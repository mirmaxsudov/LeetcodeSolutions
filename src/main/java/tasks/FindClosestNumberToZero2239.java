package tasks;

public class FindClosestNumberToZero2239 {
    public static void main(String[] args) {
        System.out.println(findClosestNumber(new int[]{-4, -2, 1, 4, 8}));
        System.out.println(findClosestNumber(new int[]{2, -1, 1}));
    }

    public static int findClosestNumber(int[] nums) {
        int val = nums[0];
        boolean isPositive = nums[0] >= 0;

        for (int i = 1; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            int abs = Math.abs(val);

            if (abs > num) {
                val = nums[i];
                isPositive = val >= 0;
            } else if (abs == num && !isPositive && num >= 0) {
                isPositive = true;
                val *= -1;
            }
        }

        return val;
    }
}