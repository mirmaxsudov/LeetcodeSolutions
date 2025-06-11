package tasks;

import java.util.Arrays;

public class FindTheDistanceValueBetweenTwoArrays1385 {
    public static void main(String[] args) {
        System.out.println(findTheDistanceValue(new int[]{4, 5, 8}, new int[]{10, 9, 1, 8}, 2));
    }

    public static int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        for (int i = 0; i < arr1.length; i++) {
            int left = 0;
            int right = arr2.length - 1;

            while (left < right) {
                int leftVal = arr2[left];

                int leftAbs = Math.abs(arr1[i] - leftVal);
                if (leftAbs <= d)
                    return leftAbs;
                if (Math.abs(arr1[i] - arr2[right]) <= d)
                    return Math.abs(arr1[i] - arr2[right]);

                left++;
            }
        }

        return -1;
    }
}