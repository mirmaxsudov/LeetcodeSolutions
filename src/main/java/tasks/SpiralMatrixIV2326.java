package tasks;

import java.util.Arrays;

public class SpiralMatrixIV2326 {
    public static void main(String[] args) {
        // 0,1,2
        ListNode root = new ListNode(0);
        root.next = new ListNode(1);
        root.next.next = new ListNode(2);

        System.out.println(Arrays.deepToString(spiralMatrix(2, 3, root)));
    }

    public static int[][] spiralMatrix(int n, int m, ListNode head) {
        int[][] res = new int[n][m];
        boolean[][] used = new boolean[n][m];
        int c = 0;
        int i = 0, j = 0;
        // RIGHT(0), DOWN(1), LEFT(2), UP(3)
        int direction = 0;

        while (c != (n * m)) {
            used[i][j] = true;
            int nextVal;

            if (head != null) {
                nextVal = head.val;
                head = head.next;
            } else {
                nextVal = -1;
            }

            switch (direction) {
                case 0 -> {
                    if (j + 1 < m && !used[i][j + 1]) {
                        j++;
                    } else {
                        direction = 1;
                        i++;
                    }
                }
                case 1 -> {
                    if (i + 1 < n && !used[i + 1][j]) {
                        i++;
                    } else {
                        direction = 2;
                        j--;
                    }
                }
                case 2 -> {
                    if (j - 1 >= 0 && !used[i][j - 1]) {
                        j--;
                    } else {
                        direction = 3;
                        i--;
                    }
                }
                case 3 -> {
                    if (i - 1 >= 0 && !used[i - 1][j]) {
                        i--;
                    } else {
                        direction = 0;
                        j++;
                    }
                }
            }

            res[i][j] = nextVal;
            c++;
        }

        return res;
    }
}