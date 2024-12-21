package tasks;

import java.util.List;

public class SnakeInMatrix3248 {
    public static void main(String[] args) {

    }

    public static int finalPositionOfSnake(int n, List<String> commands) {
        int i = 0, j = 0;

        for (String command : commands) {
            switch (command) {
                case "RIGHT" -> j++;
                case "LEFT" -> j--;
                case "UP" -> i++;
                default -> i--;
            }
        }

        return (i * n) + j;
    }
}