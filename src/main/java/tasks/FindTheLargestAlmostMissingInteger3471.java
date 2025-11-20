package tasks;

public class FindTheLargestAlmostMissingInteger3471 {
    public static void main(String[] args) {

    }

    public static int largestInteger(int[] nums, int k) {
        if (k == 1) {
            int max = -1, count = 0;

            for (int num : nums) {
                if (max < num) {
                    max = num;
                    count = 1;
                } else if (max == num) {
                    count++;
                } else {
                    if (count != 1) {
                        max = num;
                        count = 1;
                    }
                }
            }

            return max;
        }

        if (nums.length == k) {
            int max = -1;

            for (int num : nums)
                max = Math.max(max, num);

            return max;
        }


        return -1;
    }
}
