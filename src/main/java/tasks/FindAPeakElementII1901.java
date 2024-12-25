package tasks;

import java.util.Arrays;

public class FindAPeakElementII1901 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findPeakGrid(new int[][]{
                {1, 4},
                {3, 2}
        })));
    }

    public static int[] findPeakGrid(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (i == 0) {
                    if (j < mat.length - 1 && mat[i][j] > mat[i][j + 1] && mat[i + 1][j] > mat[i][j])
                        return new int[]{i, j};
                } else if (i == mat.length - 1) {
                    if (j > 0 && mat[i][j] > mat[i + 1][j] && mat[i][j] > mat[i][j + 1])
                        return new int[]{i, j};
                } else {
                    if (mat[i][j] > mat[i + 1][j]
                            && mat[i][j] > mat[i][j + 1]
                            && mat[i][j] > mat[i - 1][j]
                            && mat[i][j] > mat[i][j - 1])
                        return new int[]{i, j};
                }
            }
        }

        return new int[]{-1, -1};
    }
}