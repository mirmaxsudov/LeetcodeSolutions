package tasks;

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

    private final static List<Integer> res = new ArrayList<>();

    public static List<Integer> spiralOrder(int[][] matrix) {
        boolean[][] used = new boolean[matrix.length][matrix[0].length];
        generate(matrix, 0, 0, matrix.length - 1, matrix[0].length - 1, 1, 0, used);
        return res;
    }

    private static void generate(int[][] matrix, int i, int j, int sSize, int iSize, int dir, int count, boolean[][] used) {
        if (count == matrix.length * matrix[0].length) return;

        switch (dir) {
            // Top
            case 0 -> {
                if (i == 0) {
                    generate(matrix, i, j + 1, sSize, iSize, 1, count, used);
                } else {
                    if (used[i - 1][j]) {
                        generate(matrix, i, j + 1, sSize, iSize, 1, count, used);
                    } else {
                        res.add(matrix[i - 1][j]);
                        used[i - 1][j] = true;
                        generate(matrix, i - 1, j, sSize, iSize, 0, count, used);
                    }
                }
            }
            // Right
            case 1 -> {
                if (j == iSize) {
                    res.add(matrix[i][j]);
                    used[i][j] = true;
                    count++;
                    generate(matrix, i + 1, j, sSize, iSize, 2, count, used);
                } else {
                    res.add(matrix[i][j]);
                    used[i][j] = true;
                    count++;
                    generate(matrix, i, j + 1, sSize, iSize, 1, count, used);
                }
            }
            // Bottom
            case 2 -> {
                if (i - 1 == sSize) {
                    generate(matrix, i, j + 1, sSize, iSize, 3, count, used);
                } else {
                    res.add(matrix[i][j]);
                    used[i][j] = true;
                    count++;
                    generate(matrix, i + 1, j, sSize, iSize, 2, count, used);
                }
            }
            // Left
            case 3 -> {
                if (i - 1 == sSize && j - 1 == iSize) {
                    generate(matrix, i, j - 1, sSize, iSize, 3, count, used);
                    return;
                }

                if (j == 0) {
                    generate(matrix, i, j, sSize, iSize, 0, count, used);
                } else {
                    res.add(matrix[i - 1][j - 1]);
                    used[i - 1][j - 1] = true;
                    count++;
                    generate(matrix, i, j - 1, sSize, iSize, 3, count, used);
                }
            }
        }
    }
}