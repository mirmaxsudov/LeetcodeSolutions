package tasks;

public class MinimumPathSum64 {
    public static void main(String[] args) {
        System.out.println(minPathSum(new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        }));
    }

    // 0 => bottom | 1 => right
    public static int minPathSum(int[][] grid) {
        return Math.min(dfs(grid, 0, 0, 0, 0), dfs(grid, 0, 1, 0, 0));
    }

    private static int dfs(int[][] grid, int sum, int direction, int i, int j) {
        if (i + 1 == grid.length && j + 1 == grid[i].length)
            return sum + grid[i][j];

        // For bottom and right
        if (i < grid.length && j < grid[i].length) {
            return Math.min(
                    dfs(grid, sum + grid[i][j], 0, i + 1, j),
                    dfs(grid, sum + grid[i][j], 1, i, j + 1)
            );
        } else if (i < grid.length && j > grid[i].length)
            return dfs(grid, sum + grid[i][j], 0, i + 1, j);
        else if (i - 1 > grid.length && j < grid[i - 1].length)
            return dfs(grid, sum + grid[i - 1][j], 1, i, j + 1);
        else
            return sum;
    }
}