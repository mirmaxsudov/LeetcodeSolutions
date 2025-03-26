package dataStructres.spiralMatrix;

public class Homework {
    public static void main(String[] args) {
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        showMatrix(spiralMatrix.makeSpiral(4, 2));

    }

    public static void showMatrix(int[][] matrix) {
        for (int[] arr : matrix) {
            for (int num : arr)
                System.out.print(num + " ");

            System.out.println();
        }
    }
}