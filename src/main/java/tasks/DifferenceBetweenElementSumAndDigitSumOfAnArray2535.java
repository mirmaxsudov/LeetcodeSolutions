package tasks;

public class DifferenceBetweenElementSumAndDigitSumOfAnArray2535 {
    public static void main(String[] args) {

    }

    public static int differenceOfSum(int[] nums) {
        int dSum = 0, eSum = 0;

        for (int num : nums) {
            eSum += num;

            while (num != 0) {
                dSum += num % 10;
                num /= 10;
            }
        }

        return Math.abs(dSum - eSum);
    }
}