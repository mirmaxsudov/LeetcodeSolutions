package tasks;

import java.util.Arrays;

public class MinimumDifferenceBetweenHighestAndLowestOfKScores1984 {
    public static void main(String[] args) {
        System.out.println(minimumDifference(new int[]{90}, 1));
        System.out.println(minimumDifference(new int[]{9, 4, 1, 7}, 2));
    }

    public static int minimumDifference(int[] nums, int k) {
        int res = 0;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - k; i++) {
            for (int j = i; j < i + k; j++) {

            }
        }

        return res;
    }
}