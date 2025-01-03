package tasks;

public class NumberOfWaysToSplitArray2270 {
    public static void main(String[] args) {
        System.out.println(waysToSplitArray(new int[]{10, 4, -8, 7}) + " - " + 2);
        System.out.println(waysToSplitArray(new int[]{2, 3, 1, 0}) + " - " + 2);
        System.out.println(waysToSplitArray(new int[]{-100000, 100000}) + " - " + 0);
        System.out.println(waysToSplitArray(new int[]{0, 0}) + " - " + 1);
        System.out.println(waysToSplitArray(new int[]{-1, -2}) + " - " + 1);
    }

    public static int waysToSplitArray(int[] nums) {
        int c = 0;
        long left = 0;
        long right = 0;

        for (int num : nums) right += num;

        for (int i = 0; i < nums.length - 1; i++) {
            left += nums[i];
            right -= nums[i];

            if (left >= right)
                c++;
        }

        return c;
    }
}