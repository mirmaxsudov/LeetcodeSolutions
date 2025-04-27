package tasks;

import java.util.ArrayList;
import java.util.List;

public class LuckyNumbersInAMatrix1380 {
    public static void main(String[] args) {

    }

    public static List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            int min = Integer.MAX_VALUE;
            int minI = -1, minJ = -1;
            int max = Integer.MIN_VALUE;
            int maxI = -1, maxJ = -1;
            for (int j = 0; j < matrix[i].length; j++) {
                if (min > matrix[i][j]) {
                    min = matrix[i][j];
                    minI = i;
                    minJ = i;
                }
                if (max < matrix[i][j]) {
                    max = matrix[i][j];
                    maxI = i;
                    maxJ = j;
                }
            }

        }

        return res;
    }
}