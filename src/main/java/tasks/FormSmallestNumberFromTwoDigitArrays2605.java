package tasks;

public class FormSmallestNumberFromTwoDigitArrays2605 {
    public static void main(String[] args) {

    }

    public static int minNumber(int[] nums1, int[] nums2) {
        boolean[] isFindNum1 = new boolean[10];
        boolean[] isFindNum2 = new boolean[10];

        for (int num : nums1) isFindNum1[num] = true;

        for (int num : nums2) isFindNum2[num] = true;

        int min1 = -1, min2 = -1;

        for (int numCount = 0; numCount <= 9; numCount++) {
            if (isFindNum1[numCount] && isFindNum2[numCount])
                return numCount;

            if (isFindNum1[numCount] && min1 == -1)
                min1 = numCount;

            if (isFindNum2[numCount] && min2 == -1)
                min2 = numCount;
        }

        return Math.max(min1, min2) + (10 * Math.min(min1, min2));
    }
}
