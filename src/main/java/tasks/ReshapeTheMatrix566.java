package tasks;

public class ReshapeTheMatrix566 {
    public static void main(String[] args) {

    }

    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        if (mat.length * mat[0].length != r * c)
            return mat;

        int[][] res = new int[r][c];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                int num = mat[i][j];
                int ri = i * mat[0].length + j;
                int rj = ri % c;
                int rii = ri / c;
                res[rii][rj] = num;
            }
        }

        return res;
    }
}