package tasks;

public class FindWinnerOnATicTacToeGame1275 {
    public static void main(String[] args) {
        System.out.println(ticTacToe(new int[][]{
                {0, 0}, {2, 0}, {1, 1}, {2, 1}, {2, 2}
        }));
        System.out.println(ticTacToe(new int[][]{
                {0, 0}, {1, 1}, {0, 1}, {0, 2}, {1, 0}, {2, 0}
        }));
        System.out.println(ticTacToe(new int[][]{
                {0, 0}, {1, 1}, {2, 0}, {1, 0}, {1, 2}, {2, 1}, {0, 1}, {0, 2}, {2, 2}
        }));
        System.out.println(ticTacToe(new int[][]{
                {1, 2}, {2, 1}, {0, 0}, {0, 1}, {2, 0}, {0, 2}, {2, 2}, {1, 1}
        }));
    }

    // 3 => 011
    //          => 1
    // 1 => 001

    public static String ticTacToe(int[][] moves) {
        char[][] board = new char[3][3];

        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board[i][j] = '-';

        boolean isATurn = true, isFull = false;
        int c = 0;

        for (int[] move : moves) {
            board[move[0]][move[1]] = isATurn ? 'A' : 'B';
            isATurn = !isATurn;
            c++;
        }

        isFull = c == 9;

        char winner = findWinner(board);

        if (!isFull && winner == ('-'))
            return "Pending";

        if (isFull && winner == ('-'))
            return "Draw";

        return winner + "";
    }

    private static char findWinner(char[][] board) {
        // Checking row and column
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                if (board[i][0] == '-')
                    continue;
                return board[i][0];
            }

            if (board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                if (board[0][i] == '-')
                    continue;

                return board[0][i];
            }
        }

        // Checking left diagonal
        if (board[0][0] == board[1][1] && board[0][0] == board[2][2])
            if (board[0][0] != '-')
                return board[0][0];

        // Checking right diagonal
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0])
            return board[0][2];

        return '-';
    }
}