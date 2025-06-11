package tasks;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LuckyNumbersInAMatrix1380 {
    public static void main(String[] args) {
        System.out.println(luckyNumbers(new int[][]{
                {3, 7, 8},
                {9, 11, 13},
                {15, 16, 17}
        }));
    }

    public static List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        Set<Integer> columns = new HashSet<>();
        Set<Integer> rows = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (columns.contains(i) || rows.contains(i))
                    continue;

                boolean isValid = isValid(matrix, i, j);

                if (!isValid)
                    continue;

                rows.add(i);
                columns.add(j);
                res.add(matrix[i][j]);
            }
        }

        return res;
    }

    private static boolean isValid(int[][] matrix, int i, int j) {
        int currentNum = matrix[i][j];
        int min = currentNum;

        for (int k = 0; k < matrix[i].length; k++)
            min = Math.min(min, matrix[i][k]);

        if (min != currentNum)
            return false;

        int max = currentNum;

        for (int[] ints : matrix) max = Math.max(max, ints[j]);

        return max == currentNum;
    }
}