package tasks;

import java.util.Arrays;

public class DiagonalTraverse498 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findDiagonalOrder(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        })));
        System.out.println(Arrays.toString(findDiagonalOrder(new int[][]{
                {1, 2},
                {3, 4},
        })));
    }

    public static int[] findDiagonalOrder(int[][] mat) {
        int totalLen = mat.length * mat[0].length;
        int[] res = new int[totalLen];
        int index = 0, i = 0, j = 0;
        boolean isTop = true;

        while (index < totalLen) {
            res[index] = mat[i][j];

            // Move i and j
            if (isTop) {
                boolean hasTop = hasTop(mat, i, j), hasRight = hasRight(mat, i, j);

                if (hasTop && hasRight) {
                    i--;
                    j++;
                } else if (!hasTop && hasRight) {
                    isTop = false;
                    j++;
                } else if (!hasTop) {
                    isTop = false;
                    i++;
                }
            } else {
                boolean hasLeft = hasLeft(mat, i, j), hasBottom = hasBottom(mat, i, j);

                if (hasLeft && hasBottom) {
                    j--;
                    i++;
                } else if (!hasLeft && hasBottom) {
                    isTop = true;
                    i++;
                } else if (!hasLeft) {
                    isTop = true;
                    j++;
                }
            }
            index++;
        }

        res[res.length - 1] = mat[mat.length - 1][mat[0].length - 1];
        return res;
    }

    /** Returns true if (i, j) is a valid position inside matrix m. */
    private static boolean inBounds(int[][] m, int i, int j) {
        if (m == null || i < 0 || i >= m.length) return false;
        return m[i] != null && j >= 0 && j < m[i].length;
    }

    /** Is there a cell immediately to the LEFT of (i, j)? */
    public static boolean hasLeft(int[][] m, int i, int j) {
        return inBounds(m, i, j) && j > 0;
    }

    /** Is there a cell immediately to the RIGHT of (i, j)? */
    public static boolean hasRight(int[][] m, int i, int j) {
        return inBounds(m, i, j) && (j + 1) < m[i].length;
    }

    /** Is there a cell immediately on TOP of (i, j)? */
    public static boolean hasTop(int[][] m, int i, int j) {
        if (!inBounds(m, i, j)) return false;
        int up = i - 1;
        return up >= 0 && m[up] != null && j < m[up].length;
    }

    /** Is there a cell immediately at the BOTTOM of (i, j)? */
    public static boolean hasBottom(int[][] m, int i, int j) {
        if (!inBounds(m, i, j)) return false;
        int down = i + 1;
        return down < m.length && m[down] != null && j < m[down].length;
    }
}