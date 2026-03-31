package tasks;

import java.util.Arrays;

public class ZeroOneMatrix542 {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(updateMatrix(new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
        })));
        System.out.println(Arrays.deepToString(updateMatrix(new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        })));

    }

    public static int[][] updateMatrix(int[][] mat) {
        int[][] res = new int[mat.length][mat[0].length];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0)
                    res[i][j] = 0;
                else
                    res[i][j] = findMin(mat, i, j);
                System.out.println(res[i][j]);
            }
        }

        return res;
    }

    private static int findMin(int[][] mat, int i, int j) {
        if (mat[i][j] == 0)
            return 0;

        return Math.min(
                dfs(mat, i, j + 1, 1, new boolean[mat.length][mat[0].length]),
                Math.min(
                        dfs(mat, i + 1, j, 1, new boolean[mat.length][mat[0].length]),
                        Math.min(
                                dfs(mat, i, j - 1, 1, new boolean[mat.length][mat[0].length]),
                                dfs(mat, i - 1, j, 1, new boolean[mat.length][mat[0].length])
                        )
                )
        );
    }

    private static int dfs(int[][] mat, int i, int j, int move, boolean[][] visited) {
        if (i < 0 || i >= mat.length || j < 0 || j >= mat[0].length || visited[i][j])
            return move + 1;

        if (mat[i][j] == 0)
            return move;

        visited[i][j] = true;

        int result = Math.min(
                dfs(mat, i, j + 1, move + 1, visited),
                Math.min(
                        dfs(mat, i + 1, j, move + 1, visited),
                        Math.min(
                                dfs(mat, i, j - 1, move + 1, visited),
                                dfs(mat, i - 1, j, move + 1, visited)
                        )
                )
        );

        visited[i][j] = false;
        return result;
    }
}