package tasks;

import java.time.LocalDateTime;
import java.util.*;

public class RelativeRanks506 {
    public static void main(String[] args) {
        String time = "13:05:2024";

        String[] values = time.split(":");
        int day = Integer.parseInt(values[0]);
        int month = Integer.parseInt(values[1]);
        int year = Integer.parseInt(values[2]);

        LocalDateTime dateTime = LocalDateTime.of(year, month, day, 0, 0, 0);
        System.out.println("dateTime = " + dateTime);

    }

    public static boolean checkString(String value) {
        return value == null || value.isEmpty() || value.isBlank();
    }

    public static boolean checkPhoneNumber(String phoneNumber) {
        return phoneNumber.matches("^\\+998\\d{9}$");
    }

    public static String[] findRelativeRanks(int[] score) {
        Map<Integer, Integer> tr = new TreeMap<>(Comparator.reverseOrder());

        for (int i = 0; i < score.length; i++)
            tr.put(score[i], i);

        String[] result = new String[score.length];
        int count = 0;

        for (Map.Entry<Integer, Integer> entry : tr.entrySet()) {
            if (count == 0)
                result[entry.getValue()] = "Gold Medal";
            else if (count == 1)
                result[entry.getValue()] = "Silver Medal";
            else if (count == 2)
                result[entry.getValue()] = "Bronze Medal";
            else
                result[entry.getValue()] = Integer.toString(count + 1);

            count++;
        }

        return result;
    }
}
