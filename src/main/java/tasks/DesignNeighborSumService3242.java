package tasks;

import java.util.HashMap;
import java.util.Map;

public class DesignNeighborSumService3242 {
    public static void main(String[] args) {

    }

    static class NeighborSum {
        private Map<Integer, Pair> mp;

        public NeighborSum(int[][] grid) {
            mp = new HashMap<>();
            int len = grid[0].length;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < len; j++) {
                    Pair pair = new Pair(0, 0);
                    mp.put(grid[i][j], pair);

                    // Adjacent
                    if (i - 1 >= 0)
                        pair.adjacentSum += grid[i - 1][j];
                    if (j - 1 >= 0)
                        pair.adjacentSum += grid[i][j - 1];
                    if (i + 1 < len)
                        pair.adjacentSum += grid[i + 1][j];
                    if (j + 1 < len)
                        pair.adjacentSum += grid[i][j + 1];

                    // Diagonal
                    if (i - 1 >= 0 && j - 1 >= 0)
                        pair.diagonalSum += grid[i - 1][j - 1];
                    if (i - 1 >= 0 && j + 1 < len)
                        pair.diagonalSum += grid[i - 1][j + 1];
                    if (i + 1 < len && j - 1 >= 0)
                        pair.diagonalSum += grid[i + 1][j - 1];
                    if (i + 1 < len && j + 1 < len)
                        pair.diagonalSum += grid[i + 1][j + 1];
                }
            }
        }

        public int adjacentSum(int value) {
            return mp.get(value).adjacentSum;
        }

        public int diagonalSum(int value) {
            return mp.get(value).diagonalSum;
        }
    }

    static class Pair {
        int adjacentSum = 0;
        int diagonalSum = 0;

        public Pair(int adjacentSum, int diagonalSum) {
            this.adjacentSum = adjacentSum;
            this.diagonalSum = diagonalSum;
        }
    }
}