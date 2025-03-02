package univerLesson.DS.hw;

import java.util.*;

public class TicTacToe {
    private final char[][] board = new char[3][3];
    private int turns;
    private char currentPlayer;
    private static final char X = 'X';
    private static final char O = 'O';
    private static volatile boolean isExit = false;

    private final static Random RANDOM = new Random();
    private static final Scanner SCANNER_FOR_STR = new Scanner(System.in);
    private static final int[][][] WINNING_POSITIONS = {
            {{0, 0}, {0, 1}, {0, 2}},
            {{1, 0}, {1, 1}, {1, 2}},
            {{2, 0}, {2, 1}, {2, 2}},
            {{0, 0}, {1, 0}, {2, 0}},
            {{0, 1}, {1, 1}, {2, 1}},
            {{0, 2}, {1, 2}, {2, 2}},
            {{0, 0}, {1, 1}, {2, 2}},
            {{2, 2}, {1, 1}, {0, 0}}
    };

    public TicTacToe() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board[i][j] = '.';

        this.turns = 0;
        this.currentPlayer = X;
    }

    public void startGame() throws InterruptedException {
        while (!isExit) {
            Thread.onSpinWait();
            if (turns == 9) {
                System.out.println("Draw");
                return;
            }

            turns++;

            if (currentPlayer == X) {
                askTurnForUser();
            } else {
                askTurnForComputer();
            }
        }

        showBoard();
        System.out.println("Game over");
        System.out.println("Bye!)");
    }

    private void askTurnForUser() {
        System.out.println("X turn");
        showBoard();

        do {
            try {
                System.out.print("Enter indexes like this format: i:j [0:2]:[0:2]: ");
                String indexes = SCANNER_FOR_STR.nextLine().trim();

                System.out.println(indexes);
                System.out.println(indexes.length());

                if (indexes.length() != 3) {
                    System.out.println("Please, enter indexes like this format: i:j [0:2]:[0:2]: ");
                    continue;
                }

                String[] indexesArr = indexes.split(":");

                int i = Integer.parseInt(indexesArr[0]);
                int j = Integer.parseInt(indexesArr[1]);

                if (board[i][j] != '.') {
                    System.out.println("This field is already occupied. Choose another one.");
                    showBoard();
                    continue;
                }

                board[i][j] = X;
                togglePlayer(X);

                if (checkWin(X)) {
                    System.out.println("X wins");
                    isExit = true;
                }

                return;
            } catch (Exception ignored) {
                System.out.println("Please, enter indexes like this format: i:j [0:2]:[0:2]: ");
                System.out.println("Please, enter indexes like this format: i:j [0:2]:[0:2]: ");
                System.out.println("Please, enter indexes like this format: i:j [0:2]:[0:2]: ");
            }
        } while (true);
    }

    private boolean checkWin(char player) {
        for (int[][] winningPosition : WINNING_POSITIONS)
            if (board[winningPosition[0][0]][winningPosition[0][1]] == player &&
                    board[winningPosition[1][0]][winningPosition[1][1]] == player &&
                    board[winningPosition[2][0]][winningPosition[2][1]] == player)
                return true;

        return false;
    }

    private void togglePlayer(char player) {
        currentPlayer = player == X ? O : X;
    }

    private void showBoard() {
        System.out.println("___________________");
        System.out.println("|  " + board[0][0] + "  |  " + board[0][1] + "  |  " + board[0][2] + "  |");
        System.out.println("-------------------");
        System.out.println("|  " + board[1][0] + "  |  " + board[1][1] + "  |  " + board[1][2] + "  |");
        System.out.println("-------------------");
        System.out.println("|  " + board[2][0] + "  |  " + board[2][1] + "  |  " + board[2][2] + "  |");
        System.out.println("-------------------");
    }

    private void askTurnForComputer() throws InterruptedException {
        System.out.println("O turn");
        showBoard();

        System.out.println("Computer is thinking...");
        Thread.sleep(2000);

        List<int[]> availablePositions = getAvailablePositions();

        if (availablePositions.isEmpty()) {
            System.out.println("Draw");
            return;
        }

        int randomIndex = getRandomWithMinAndMax(0, availablePositions.size() - 1);
        int[] position = availablePositions.get(randomIndex);

        board[position[0]][position[1]] = O;
        togglePlayer(O);

        if (checkWin(O)) {
            System.out.println("O wins");
            isExit = true;
        }
    }

    private List<int[]> getAvailablePositions() {
        List<int[]> availablePositions = new ArrayList<>();

        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[i].length; j++)
                if (board[i][j] == '.')
                    availablePositions.add(new int[]{i, j});
        return availablePositions;
    }

    private int getRandomWithMinAndMax(int min, int max) {
        return RANDOM.nextInt((max - min) + 1) + min;
    }
}