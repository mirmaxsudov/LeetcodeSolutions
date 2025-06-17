package tasks;

public class LargestNumberAtLeastTwiceOfOthers747 {
    public static void main(String[] args) {

    }

    public static int dominantIndex(int[] nums) {
        int max = Integer.MIN_VALUE;
        int index = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }

        for (int num : nums) {
            if (max == num)
                continue;
            if (num * 2 > max)
                return -1;
        }

        return index;
    }
}