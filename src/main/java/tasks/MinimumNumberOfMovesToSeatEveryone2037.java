package tasks;

import java.util.Arrays;

public class MinimumNumberOfMovesToSeatEveryone2037 {
    public static void main(String[] args) {
        System.out.println(minMovesToSeat(new int[]{3, 1, 5}, new int[]{2, 7, 4}));
    }

    public static int minMovesToSeat(int[] seats, int[] students) {
        int minOperation = 0;

        Arrays.sort(seats);
        Arrays.sort(students);

        for (int i = 0; i < seats.length; i++) {
            int seat = seats[i];
            int student = students[i];

            minOperation += (Math.abs(seat - student));
        }

        return minOperation;
    }
}