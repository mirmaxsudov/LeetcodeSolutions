package univerLesson.DS;

public class Task {
    public static void main(String[] args) {
        homeWork(6, 11);
    }

    public static void homeWork(int n, int m) {
        boolean[][] matrix = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == j || ((j - i) == Math.abs(m - n))) {
                    matrix[i][j] = true;
                } else if (i + j == m - 1 || i + j == n - 1) {
                    matrix[i][j] = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j]) {
                    System.out.print(" O ");
                } else {
                    System.out.print(" . ");
                }
            }
            System.out.println();
        }
    }

    public static void drawChess(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i % 2 == 0 && j % 2 == 0) {
                    System.out.print(" O ");
                } else {
                    System.out.print(" B ");
                }
            }
            System.out.println();
        }
    }

    public static void draw(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i + j == n - 1 || i == j || i == n / 2 || j == n / 2) {
                    System.out.print(" & ");
                } else {
                    System.out.print(" . ");
                }
            }
            System.out.println();
        }
    }
}
