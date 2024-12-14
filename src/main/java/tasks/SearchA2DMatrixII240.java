package tasks;

public class SearchA2DMatrixII240 {
    public static void main(String[] args) {
        System.out.println(searchMatrix(
                new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}},
                5
        ));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length - 1;
        int rows = matrix.length;
        while (row < rows && col >= 0) {
            if (matrix[row][col] < target) {
                ++row;
            } else if (matrix[row][col] > target) {
                --col;
            } else {
                return true;
            }
        }
        return false;
    }
}