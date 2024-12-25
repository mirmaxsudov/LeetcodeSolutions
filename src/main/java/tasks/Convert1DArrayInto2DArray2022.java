package tasks;

import java.util.Arrays;

public class Convert1DArrayInto2DArray2022 {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(construct2DArray(new int[]{1, 2, 3, 4}, 2, 2)));
        System.out.println(Arrays.deepToString(construct2DArray(new int[]{1, 2, 3}, 1, 3)));
        System.out.println(Arrays.deepToString(construct2DArray(new int[]{1, 2}, 1, 1)));
    }

    public static int[][] construct2DArray(int[] original, int m, int n) {
        if (original.length > m * n)
            return new int[0][0];

        int[][] res = new int[m][n];
        int mI = 0;
        int oI = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[mI][j] = original[oI++];
            }

            mI++;
        }

        return res;
    }
}