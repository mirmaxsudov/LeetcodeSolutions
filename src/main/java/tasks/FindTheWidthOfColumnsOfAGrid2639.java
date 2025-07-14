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
        int len = grid[0].length;
        int[] res = new int[len];

        for (int i = 0; i < len; i++) {
            int max = 0;
            int l = 0;
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] < 0)
                    l++;
                l += String.valueOf(grid[i][j]).length() - 1;
            }
            max = Math.max(max, l);
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