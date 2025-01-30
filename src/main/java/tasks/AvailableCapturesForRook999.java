package tasks;

public class AvailableCapturesForRook999 {
    public static void main(String[] args) {
        System.out.println(numRookCaptures(
                new char[][]{
                        {'.', '.', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', 'p', '.', '.', '.', '.'},
                        {'.', '.', '.', 'R', '.', '.', '.', 'p'},
                        {'.', '.', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', 'p', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.', '.', '.'}
                }
        ) + " - " + 3);
    }

    public static int numRookCaptures(char[][] board) {
        int i = 0, j = 0;

        p:
        for (int a = 0; a < board.length; a++)
            for (int b = 0; b < board[a].length; b++)
                if (board[a][b] == 'R') {
                    i = a;
                    j = b;
                    break p;
                }

        return count(board, i, j, 0) + count(board, i, j, 1) + count(board, i, j, 2) + count(board, i, j, 3);
    }

    public static int count(char[][] board, int i, int j, int direction) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length)
            return 0;

        if (board[i][j] == 'p')
            return 1;

        if (board[i][j] == 'B')
            return 0;

        return switch (direction) {
            case 0 -> count(board, i - 1, j, direction);
            case 1 -> count(board, i, j + 1, direction);
            case 2 -> count(board, i + 1, j, direction);
            default -> count(board, i, j - 1, direction);
        };
    }
}