package tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RottingOranges994 {
    public static void main(String[] args) {
        RottingOranges994 main = new RottingOranges994();
        System.out.println(main.orangesRotting(new int[][]{
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        }));
    }

    public int orangesRotting(int[][] grid) {
        List<int[]> rottensIndexes = new ArrayList<>();
        int freshOranges = 0;

        // We will find all rotter indexes
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2)
                    rottensIndexes.add(new int[]{i, j});
                else if (grid[i][j] == 1)
                    freshOranges++;
            }

        boolean isRotten = true;
        int minute = 0;

        while (isRotten) {
            List<int[]> newRottenIndexes = new ArrayList<>();

            boolean isNewRotten = false;
            for (int[] rottensIndex : rottensIndexes) {
                int i = rottensIndex[0], j = rottensIndex[1];

                // We will check from top - right - bottom and left.
                // top
                if (i - 1 >= 0) {
                    if (grid[i - 1][j] == 1) {
                        newRottenIndexes.add(new int[]{i - 1, j});
                        grid[i - 1][j] = 2;
                        isNewRotten = true;
                        freshOranges--;
                    }
                }
                // right
                if (j + 1 < grid[0].length) {
                    if (grid[i][j + 1] == 1) {
                        newRottenIndexes.add(new int[]{i, j + 1});
                        grid[i][j + 1] = 2;
                        isNewRotten = true;
                        freshOranges--;
                    }
                }
                // bottom
                if (i + 1 < grid.length) {
                    if (grid[i + 1][j] == 1) {
                        newRottenIndexes.add(new int[]{i + 1, j});
                        grid[i + 1][j] = 2;
                        isNewRotten = true;
                        freshOranges--;
                    }
                }
                // left
                if (j - 1 >= 0) {
                    if (grid[i][j - 1] == 1) {
                        newRottenIndexes.add(new int[]{i, j - 1});
                        grid[i][j - 1] = 2;
                        isNewRotten = true;
                        freshOranges--;
                    }
                }
            }

            if (!isNewRotten)
                isRotten = false;

            System.out.println("newRottenIndexes = " + showList(newRottenIndexes));
            System.out.println("rottensIndexes = " + showList(rottensIndexes));
            rottensIndexes = newRottenIndexes;
            minute++;
        }

        return freshOranges == 0 ? minute : -1;
    }

    private String showList(List<int[]> list) {
        StringBuilder sb = new StringBuilder();

        for (int[] arr : list)
            sb.append(Arrays.toString(arr)).append(" - ");

        return sb.toString();
    }
}