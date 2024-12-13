package tasks;

public class ValidBoomerang1037 {
    public static void main(String[] args) {

    }

    public static boolean isBoomerang(int[][] points) {

        for (int i = 0; i < points.length - 2; i++) {
            if (!(isSame(points[i]) && isSame(points[i + 1]) && isSame(points[i + 2]))) {
                return false;
            }
        }

        return true;
    }

    public static boolean isSame(int[] point) {
        return point[0] != point[1];
    }
}