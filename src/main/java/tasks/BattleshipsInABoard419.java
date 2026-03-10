package tasks;

public class BattleshipsInABoard419 {
    public static void main(String[] args) {

    }

    public int countBattleships(char[][] board) {
        int count = 0;
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'X' && !visited[i][j]) {
                    count++;
                    dfs(board, visited, i, j);
                }
            }
        }

        return count;
    }

    private void dfs(char[][] board, boolean[][] visited, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] != 'X' || visited[i][j])
            return;


        visited[i][j] = true;

        dfs(board, visited, i + 1, j); // Down
        dfs(board, visited, i - 1, j); // Up
        dfs(board, visited, i, j + 1); // Right
        dfs(board, visited, i, j - 1); // Left
    }
}
