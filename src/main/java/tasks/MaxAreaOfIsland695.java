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
                if (grid[i][j] == 1 && !isVisited[i][j]) {
                    int maxArea = walk(isVisited, grid, i, j);
                    max = Math.max(max, maxArea);
                }
            }
        }

        return max;
    }

    private static int walk(boolean[][] isVisited, int[][] grid, int i, int j) {
//        (i + 1, j - 1) - (i + 1, j) - (i + 1, j + 1) - (i, j + 1)
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || isVisited[i][j] || grid[i][j] == 0)
            return 0;

        isVisited[i][j] = true;
        return walk(isVisited, grid, i + 1, j) + walk(isVisited, grid, i - 1, j) + walk(isVisited, grid, i, j + 1) + walk(isVisited, grid, i, j - 1) + 1;
    }
}
