package tasks;

public class CheckIfItIsAStraightLine1232 {
    public static void main(String[] args) {

    }

    public static boolean checkStraightLine(int[][] coordinates) {
        int d = coordinates[0][1] - coordinates[0][0];

        for (int[] coordinate : coordinates)
            if ((coordinate[1] - coordinate[0] != d))
                return false;

        return true;
    }
}