package tasks;

public class SpecialPositionsInABinaryMatrix1582 {
    public static void main(String[] args) {
        System.out.println(numSpecial(new int[][]{
                {1, 0, 0},
                {0, 0, 1},
                {1, 0, 0}
        }));
    }

    public static int numSpecial(int[][] mat) {
        int res = 0;

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0)
                    continue;

                if (checkRow(mat, i, j, mat[i].length) && checkCol(mat, j, i, mat.length))
                    res++;
            }
        }

        return res;
    }

    private static boolean checkRow(int[][] mat, int i, int col, int length) {
        for (int j = 0; j < length; j++) {
            if (j == col)
                continue;
            if (mat[i][j] != 0)
                return false;
        }

        return true;
    }

    private static boolean checkCol(int[][] mat, int k, int row, int length) {
        for (int i = 0; i < length; i++) {
            if (i == row)
                continue;
            if (mat[i][k] != 0)
                return false;
        }

        return true;
    }
}