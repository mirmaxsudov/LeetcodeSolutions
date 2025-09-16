package tasks;

import java.util.Arrays;

public class FindTheDistanceValueBetweenTwoArrays1385 {
    public static void main(String[] args) {
        System.out.println(findClosestNum(6, new int[]{4, 5, 8}));
        System.out.println(findClosestNum(1, new int[]{4, 5, 8}));

//        System.out.println(findTheDistanceValue(new int[]{4, 5, 8}, new int[]{10, 9, 1, 8}, 2));
    }

    public static int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int res = 0;

        for (int i = 0; i < arr1.length; i++) {
            int num = arr1[i];

            for (int n : arr2)
                if (Math.abs(n) != Math.abs(n) && Math.abs(n - num) <= d)
                    res++;
        }

        return 0;
    }

    public static int findClosestNum(int num, int[] arr) {
        int prefDif = Integer.MAX_VALUE;
        int res = num;
        for (int n : arr) {
            if (Math.abs(n - num) < prefDif) {
                prefDif = Math.abs(n - num);
                res = n;
            }
        }

        return res;
    }
}