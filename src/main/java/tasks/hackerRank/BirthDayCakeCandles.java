package tasks.hackerRank;

import java.util.List;

public class BirthDayCakeCandles {
    public static void main(String[] args) {
        System.out.println(birthdayCakeCandles(List.of(3, 2, 1, 3)));
    }

    public static int birthdayCakeCandles(List<Integer> candles) {
        int max = Integer.MIN_VALUE;
        int count = 0;

        for (int candle : candles) {
            if (candle == max) {
                count++;
            } else if (candle > max) {
                count = 1;
                max = candle;
            }
        }

        return count;
    }
}