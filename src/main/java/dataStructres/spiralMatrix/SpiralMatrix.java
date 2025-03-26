package dataStructres.spiralMatrix;

public class SpiralMatrix {
    enum Direction {
        LEFT, RIGHT, TOP, BOTTOM;
    }

    public int[][] makeSpiral(int n, int m) {
        int[][] res = new int[n][m];
        boolean[][] used = new boolean[n][m];

        int stepCount = 0;
        int i = 0, j = 0;
        int num = 1;
        Direction direction = Direction.RIGHT;

        while (stepCount != n * m) {
            if (used[i][j])
                continue;

            res[i][j] = num++;
            used[i][j] = true;

            switch (direction) {
                case LEFT -> {
                    if (j - 1 >= 0 && !used[i][j - 1])
                        j--;
                    else {
                        direction = Direction.TOP;
                        i--;
                    }
                }
                case RIGHT -> {
                    if (j + 1 < m && !used[i][j + 1])
                        j++;
                    else {
                        direction = Direction.BOTTOM;
                        i++;
                    }
                }
                case TOP -> {
                    if (i - 1 >= 0 && !used[i - 1][j])
                        i--;
                    else {
                        direction = Direction.RIGHT;
                        j++;
                    }
                }
                case BOTTOM -> {
                    if (i + 1 < n && !used[i + 1][j])
                        i++;
                    else {
                        direction = Direction.LEFT;
                        j--;
                    }
                }
            }

            stepCount++;
        }

        return res;
    }
}