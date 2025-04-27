package tasks;

public class ReshapeTheMatrix566 {
    public static void main(String[] args) {

    }

    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        int[][] res = new int[r][c];

        int ri = 0, rj = 0;

        for (int[] array : mat) {
            for (int num : array) {
                res[ri][rj] = num;

                if (rj + 1 == c) {
                    rj = 0;
                    ri++;
                } else {
                    rj++;
                }
            }
        }

        return res;
    }
}