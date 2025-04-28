package tasks;

public class MakeASquareWithTheSameColor3127 {
    public static void main(String[] args) {

    }

    public static boolean canMakeSquare(char[][] grid) {
        for (int i = 0; i < grid.length - 1; i++) {
            for (int j = 0; j < grid[i].length - 1; j++) {
                int c = grid[i][j] == 'B' ? 1 : 0;
                c += grid[i + 1][j] == 'B' ? 1 : 0;
                c += grid[i][j + 1] == 'B' ? 1 : 0;
                c += grid[i + 1][j + 1] == 'B' ? 1 : 0;

                if (c % 2 == 1 || c == 0 || c == 4)
                    return true;
            }
        }

        return false;
    }
}