package tasks;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CountSubIslands1905 {
    public static void main(String[] args) {
        CountSubIslands1905 obj = new CountSubIslands1905();
        System.out.println(obj.countSubIslands(new int[][]{
                {1, 1, 1, 0, 0},
                {0, 1, 1, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 1, 1}
        }, new int[][]{
                {1, 1, 1, 0, 0},
                {0, 0, 1, 1, 1},
                {0, 1, 0, 0, 0},
                {1, 0, 1, 1, 0},
                {0, 1, 0, 1, 0}
        }));
    }

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int count = 0;
        List<List<int[]>> islands = new LinkedList<>();
        readAllIslands(grid2, islands);

        p:
        for (List<int[]> island : islands) {
            for (int[] coords : island)
                if (grid1[coords[0]][coords[1]] != 1)
                    continue p;
            count++;
        }

        return count;
    }

    private void readAllIslands(int[][] grid, List<List<int[]>> islands) {
        if (grid == null)
            return;

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    List<int[]> island = new ArrayList<>();
                    dfs(grid, visited, i, j, island);
                    islands.add(island);
                }
            }
        }
    }

    private void dfs(int[][] grid, boolean[][] visited, int i, int j, List<int[]> islands) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || visited[i][j] || grid[i][j] == 0)
            return;

        visited[i][j] = true;
        islands.add(new int[]{i, j});
        dfs(grid, visited, i + 1, j, islands);
        dfs(grid, visited, i - 1, j, islands);
        dfs(grid, visited, i, j + 1, islands);
        dfs(grid, visited, i, j - 1, islands);
    }
}