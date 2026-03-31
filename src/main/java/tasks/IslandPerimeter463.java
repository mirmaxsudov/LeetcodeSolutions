package tasks;

public class IslandPerimeter463 {
    public static void main(String[] args) {

    }

    public int islandPerimeter(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        return dfs(grid, 0, 0, visited);
    }

    private int dfs(int[][] grid, int i, int j, boolean[][] visited) {
        if (grid.length <= i || grid[0].length <= j || i < 0 || j < 0 || visited[i][j])
            return 0;
        visited[i][j] = true;
        int sum = dfs(grid, i, j + 1, visited) +
                dfs(grid, i + 1, j, visited) +
                dfs(grid, i, j - 1, visited) +
                dfs(grid, i - 1, j, visited);

        if (grid[i][j] == 1) {
            sum += 4;

            // We will check 4 sides if there exists each side, we will remove 1 from sum.
            if (i + 1 < grid.length && grid[i + 1][j] == 1)
                sum -= 1;
            if (i - 1 >= 0 && grid[i - 1][j] == 1)
                sum -= 1;
            if (j + 1 < grid[0].length && grid[i][j + 1] == 1)
                sum -= 1;
            if (j - 1 >= 0 && grid[i][j - 1] == 1)
                sum -= 1;
        }

        return sum;
    }
}