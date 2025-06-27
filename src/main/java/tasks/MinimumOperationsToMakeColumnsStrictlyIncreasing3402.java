package tasks;

public class MinimumOperationsToMakeColumnsStrictlyIncreasing3402 {
    public static void main(String[] args) {
        System.out.println(minimumOperations(new int[][]{
                {3, 2},
                {1, 3},
                {3, 4},
                {0, 1}
        }));
    }

    public static int minimumOperations(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int operations = 0;

        for (int col = 0; col < n; col++) {
            for (int row = 1; row < m; row++) {
                if (grid[row][col] <= grid[row - 1][col]) {
                    operations += grid[row - 1][col] - grid[row][col] + 1;
                    grid[row][col] = grid[row - 1][col] + 1;
                }
            }
        }
        return operations;
    }
}