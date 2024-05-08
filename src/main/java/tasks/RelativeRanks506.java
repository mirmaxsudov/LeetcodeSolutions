package tasks;

import java.util.*;

public class RelativeRanks506 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findRelativeRanks(new int[]{5, 4, 3, 2, 1})));
        System.out.println(Arrays.toString(findRelativeRanks(new int[]{10, 3, 8, 9, 4})));
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
