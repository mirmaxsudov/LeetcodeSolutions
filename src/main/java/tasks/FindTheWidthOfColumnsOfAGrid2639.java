package tasks;

import java.util.Arrays;

public class FindTheWidthOfColumnsOfAGrid2639 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findColumnWidth(new int[][]{
                {1},
                {22},
                {333}
        })));
    }

    public static int[] findColumnWidth(int[][] grid) {
        int[] res = new int[grid.length];

        for (int i = 0; i < grid.length; i++) {
            int max = 0;

            for (int[] nums : grid)
                max = Math.max(max, findLen(nums[i]));

            res[i] = max;
        }

        return res;
    }

    private static int findLen(int num) {
        int len = num < 0 ? 1 : 0;

        while (num != 0) {
            num /= 10;
            len++;
        }

        return len;
    }
}