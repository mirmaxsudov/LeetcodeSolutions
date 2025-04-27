package tasks;

public class SumOfVariableLengthSubarrays3427 {
    public static void main(String[] args) {

    }

    public static int subarraySum(int[] nums) {
//      [2,3,1]
//      0 => [2] => [0, 0];
//      1 => [2, 3] => [0, 1];
//      2 => [2, 3, 1] => [0, 2];

            int s = 0;

            for (int i = 0; i < nums.length; i++) {
                for (int j = Math.max(0, i - nums[i]); j <= i; j++) {
                    s += nums[j];
                }
            }

            return s;
    }
}