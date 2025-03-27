package tasks;

import java.util.Arrays;

public class SpiralMatrixIV2326 {
    public static void main(String[] args) {
        // 0,1,2
        ListNode root = new ListNode(0);
        root.next = new ListNode(1);
        root.next.next = new ListNode(2);

        System.out.println(Arrays.deepToString(spiralMatrix(1, 4, root)));
    }

    public static int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] res = new int[m][n];
        boolean[][] used = new boolean[m][n];

        // Dir -> 0 = RIGHT, 1 = BOTTOM, 2 = LEFT and 3 = TOP;
        int i = 0, j = 0, stepCount = 0, dir = 0;

        while (stepCount != m * n) {
            if (used[i][j])
                continue;

            used[i][j] = true;
            stepCount++;

            if (head != null) {
                res[i][j] = head.val;
                head = head.next;
            } else
                res[i][j] = -1;

            switch (dir) {
                case 2 -> {
                    if (j - 1 >= 0 && !used[i][j - 1])
                        j--;
                    else {
                        i--;
                        dir = 3;
                    }
                }
                case 0 -> {
                    if (j + 1 < m && !used[i][j + 1])
                        j++;
                    else {
                        dir = 1;
                        i++;
                    }
                }
                case 3 -> {
                    if (i - 1 >= 0 && !used[i - 1][j])
                        i--;
                    else {
                        dir = 0;
                        j++;
                    }
                }
                case 1 -> {
                    if (i + 1 < n && !used[i + 1][j])
                        i++;
                    else {
                        dir = 2;
                        j--;
                    }
                }
            }
        }

        return res;
    }
}