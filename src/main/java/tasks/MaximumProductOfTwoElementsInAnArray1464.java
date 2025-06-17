package tasks;

public class MaximumProductOfTwoElementsInAnArray1464 {
    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{10, 2, 5, 2}));
    }

    public static int maxProduct(int[] nums) {
        int max = -1, secondMax = -1;

        for (int num : nums) {
            if (num >= max) {
                secondMax = max;
                max = num;
            } else if (num >= secondMax)
                secondMax = num;
        }

        return (max - 1) * (secondMax - 1);
    }
}