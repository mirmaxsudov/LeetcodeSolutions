package tasks;

public class FindTheArrayConcatenationValue2562 {
    public static void main(String[] args) {
        System.out.println(findTheArrayConcVal(new int[]{7, 52, 2, 4})); // 596
        System.out.println(findTheArrayConcVal(new int[]{5, 14, 13, 8, 12})); // 673
        System.out.println(findTheArrayConcVal(new int[]{1, 78, 27, 48, 14, 86, 79, 68, 77, 20, 57, 21, 18, 67, 5, 51, 70, 85, 47, 56, 22, 79, 41, 8, 39, 81, 59, 74, 14, 45, 49, 15, 10, 28})); // 74322
    }

    public static long findTheArrayConcVal(int[] nums) {
        int left = 0, right = nums.length - 1;
        long sum = 0;

        while (left <= right) {
            if (left == right && (nums.length & 1) == 1)
                sum += nums[left];
            else
                sum += ((long) nums[left] * getZeroCount(nums[right]) + nums[right]);
            left++;
            right--;
        }

        return sum;
    }

    public static int getZeroCount(int num) {
        return Integer.parseInt("1" + "0".repeat(String.valueOf(num).length()));
    }
}