package tasks;

public class ReshapeTheMatrix566 {
    public static void main(String[] args) {

    }

    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        int[] h = new int[mat.length * mat[0].length];
        int i = 0;

        for (int[] arr : mat)
            for (int n : arr)
                h[i++] = n;

        if (mat.length * mat[0].length != r * c)
            return new int[][]{};

        int[][] res = new int[r][c];
        int mI = 0;
        int oI = 0;

        for (i = 0; i < r; i++) {
            for (int j = 0; j < c; j++)
                res[mI][j] = h[oI++];

            mI++;
        }

        return res;
    }
}