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
        int i = 0, j = 0, c = 0;
        int dir = 0;

        while (c != n * m) {
            int val = head == null ? -1 : head.val;
            used[i][j] = true;
            res[i][j] = val;
            if (head != null)
                head = head.next;

            switch (dir) {
                case 2 -> {
                    if (j - 1 >= 0 && !used[i][j - 1])
                        j--;
                    else {
                        i--;
                        dir++;
                    }
                }
                case 0 -> {
                    if (j + 1 < m && !used[i][j + 1])
                        j++;
                    else {
                        i++;
                        dir++;
                    }
                }
                case 3 -> {
                    if (i - 1 >= 0 && !used[i - 1][j])
                        i--;
                    else {
                        j++;
                        dir = 0;
                    }
                }
                case 1 -> {
                    if (i + 1 < n && !used[i + 1][j])
                        i++;
                    else {
                        j--;
                        dir++;
                    }
                }
            }

            c++;
        }

        return res;
    }
}