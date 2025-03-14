package tasks;

import java.util.Arrays;

public class HeightChecker1051 {
    public static void main(String[] args) {
        System.out.println(heightChecker(new int[]{1, 1, 4, 2, 1, 3}) + " " + 3);
        System.out.println(heightChecker(new int[]{5, 1, 2, 3, 4}) + " " + 5);
        System.out.println(heightChecker(new int[]{1, 2, 3, 4, 5}) + " " + 0);
    }

    public static int heightChecker(int[] heights) {
        int[] f = Arrays.copyOf(heights, heights.length);
        Arrays.sort(heights);


        int count = 0;

        for (int i = 0; i < heights.length; i++)
            if (heights[i] != f[i])
                count++;

        return count;
    }
}