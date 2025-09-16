package tasks;

public class NumberOfIslands200 {
    public static void main(String[] args) {
        System.out.println(numIslands(new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        }));
    }

    public static int numIslands(char[][] grid) {
        int num = 0;
        for (int i = 0; i < grid.length; i++)
            for (int k = 0; k < grid[i].length; k++)
                if (grid[i][k] == '1' && isIslands(grid, i, k))
                    num++;

        return num;
    }

    private static boolean isIslands(char[][] grid, int i, int k) {
        if (grid[i][k] == '0')
            return false;

        return isIslands(grid, i + 1, k) || isIslands(grid, i, k + 1);
    }
}