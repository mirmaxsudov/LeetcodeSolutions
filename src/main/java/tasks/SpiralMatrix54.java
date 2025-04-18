package tasks;

import dataStructres.spiralMatrix.SpiralMatrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix54 {
    public static void main(String[] args) {
        System.out.println(spiralOrder(
                new int[][]{
                        {1, 2, 3},
                        {5, 6, 7},
                        {9, 10, 11}
                }
        ));
    }

    enum Dir {
        LEFT, RIGHT, TOP, BOTTOM;
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        int i = 0, j = 0, usedCount = 0, n = matrix.length, m = matrix[0].length;
        boolean[][] used = new boolean[n][m];
        Dir dir = Dir.RIGHT;

        while (usedCount != n * m) {
            used[i][j] = true;
            res.add(matrix[i][j]);

            switch (dir) {
                case LEFT -> {
                    if (j - 1 >= 0 && !used[i][j - 1])
                        j--;
                    else {
                        i--;
                        dir = Dir.TOP;
                    }
                }
                case RIGHT -> {
                    if (j + 1 < m && !used[i][j + 1])
                        j++;
                    else {
                        i++;
                        dir = Dir.BOTTOM;
                    }
                }
                case TOP -> {
                    if (i - 1 >= 0 && !used[i - 1][j])
                        i--;
                    else {
                        j++;
                        dir = Dir.RIGHT;
                    }
                }
                case BOTTOM -> {
                    if (i + 1 < n && !used[i + 1][j])
                        i++;
                    else {
                        j--;
                        dir = Dir.LEFT;
                    }
                }
            }

            usedCount++;
        }

        return res;
    }
}