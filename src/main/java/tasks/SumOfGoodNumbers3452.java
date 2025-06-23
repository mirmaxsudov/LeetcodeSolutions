package tasks;

public class SumOfGoodNumbers3452 {
    public static void main(String[] args) {

    }

    public static int sumOfGoodNumbers(int[] nums, int k) {
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i - k < 0 && i + k >= nums.length) {
                sum += nums[i];
            } else if (i - k < 0) {
                if (i + k < nums.length && nums[i] > nums[i + k])
                    sum += nums[i];
            } else if (i + k >= nums.length) {
                if (i - k >= 0 && nums[i] > nums[i - k])
                    sum += nums[i];
            } else if (nums[i] > nums[i - k] && nums[i] > nums[i + k]) {
                sum += nums[i];
            }
        }

        return sum;
    }
}