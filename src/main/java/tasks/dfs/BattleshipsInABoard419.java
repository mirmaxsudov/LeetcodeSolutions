package tasks.dfs;

import java.util.ArrayList;
import java.util.List;

public class BattleshipsInABoard419 {
    public static void main(String[] args) {

    }

    private boolean[][] USED;
    private int result = 0;

    class Pair {
        int i;
        int j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public int countBattleships(char[][] board) {
        USED = new boolean[board.length][board[0].length];

        dfs(board, 0, 0, new ArrayList<>());

        return result;
    }

    private void dfs(char[][] board, int i, int j, List<Pair> indexes) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || USED[i][j] || board[i][j] == '.')
            return;

        indexes.add(new Pair(i, j));
        USED[i][j] = true;

        dfs(board, i + 1, j, indexes);
        dfs(board, i - 1, j, indexes);
        dfs(board, i, j + 1, indexes);
        dfs(board, i, j - 1, indexes);

        if (indexes.size() == 1) result++;
    }
}