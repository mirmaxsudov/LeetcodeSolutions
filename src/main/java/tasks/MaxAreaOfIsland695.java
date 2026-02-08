package tasks;

public class MaxAreaOfIsland695 {
    public static void main(String[] args) {
        System.out.println(maxAreaOfIsland(new int[][]{{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {
                0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0}, {
                0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0}, {
                0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}}));
    }

    static boolean[][] isVisited;

    public static int maxAreaOfIsland(int[][] grid) {
        int max = 0;

        isVisited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    int maxArea = walk(isVisited, grid, i, j, 0);
                    max = Math.max(max, maxArea);
                }
            }
        }

        return max;
    }

    private static int walk(boolean[][] isVisited, int[][] grid, int i, int j, int count) {
//        (i + 1, j - 1) - (i + 1, j) - (i + 1, j + 1) - (i, j + 1)

        if (!isVisited[i][j] && grid[i][j] == 1)
            count++;

        isVisited[i][j] = true;

        if (i + 1 < isVisited.length) {
            if (!isVisited[i + 1][j]) {
                isVisited[i + 1][j] = true;
                System.out.println(grid[i + 1][j]);
                System.out.println(i + 1 + " " + j);
                count += walk(isVisited, grid, i + 1, j, 0);
            }
        } else if (j + 1 < isVisited[i].length) {
            if (!isVisited[i][j + 1]) {
                isVisited[i][j + 1] = true;
                count += walk(isVisited, grid, i, j + 1, 0);
            }
        }

        return count;
    }
}
