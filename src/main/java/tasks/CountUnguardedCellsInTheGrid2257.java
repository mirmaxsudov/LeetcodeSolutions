package tasks;

public class CountUnguardedCellsInTheGrid2257 {
    public static void main(String[] args) {

    }

    public static int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int sum = 0;

        int[][] grid = new int[m][n];

        for (int[] wall : walls)
            grid[wall[0]][wall[1]] = 2;

        for (int[] guard : guards) {
            grid[guard[0]][guard[1]] = 1;

            // l - 1, t - 2, r - 3 and b - 4

            checkAndMakeGuard(grid, guard[0], guard[1] - 1, 1);
            checkAndMakeGuard(grid, guard[0] - 1, guard[1], 2);
            checkAndMakeGuard(grid, guard[0], guard[1] + 1, 3);
            checkAndMakeGuard(grid, guard[0] + 1, guard[1], 4);
        }

        for (int[] vals : grid)
            for (int val : vals)
                if (val == 0)
                    sum += 1;

        return sum;
    }

    private static void checkAndMakeGuard(int[][] grid, int i, int j, int dir) {
        while (grid.length > i && i >= 0 && grid[i].length > j && j >= 0) {
            if (grid[i][j] == 2)
                break;

            grid[i][j] = 1;

            switch (dir) {
                case 1 -> j--;
                case 2 -> i--;
                case 3 -> j++;
                case 4 -> i++;
            }
        }
    }
}