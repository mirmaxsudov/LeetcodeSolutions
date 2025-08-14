package tasks;

import java.util.Arrays;

public class RotatingTheBox1861 {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(rotateTheBox(new char[][]{{
                '#', '.', '*', '#'
        }})));
        System.out.println(Arrays.deepToString(rotateTheBox(new char[][]{{
                '#', '.', '*', '.'
        }, {
                '#', '#', '*', '.'
        }})));
        System.out.println(Arrays.deepToString(rotateTheBox(new char[][]{{
                '#', '#', '*', '.', '*', '.'
        }, {
                '#', '#', '#', '*', '.', '.'
        }, {
                '#', '#', '#', '.', '#', '.'
        }})));
    }

    public static char[][] rotateTheBox(char[][] boxGrid) {
        char[][] movedToLeftBox = moveToLeftBox(boxGrid);
        int m = movedToLeftBox.length;
        int n = movedToLeftBox[0].length;
        char[][] res = new char[n][m];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < movedToLeftBox[i].length; j++)
                res[j][m - 1 - i] = movedToLeftBox[i][j];

        return res;
    }

    private static char[][] moveToLeftBox(char[][] boxGrid) {
        for (char[] row : boxGrid) {
            int left, right;
            left = right = row.length - 1;

            while (left >= 0) {
                if (row[left] != '.') {
                    if (row[left] == '*') {
                        // If stationary obstacle
                        right = left - 1;
                        left--;
                    } else {
                        // If stone
                        if (row[right] == '#') {
                            right--;
                            left--;
                            continue;
                        }
                        row[right--] = '#';
                        row[left--] = '.';
                    }
                } else {
                    left--;
                }
            }
        }
        return boxGrid;
    }
}