package tasks;

import java.util.HashSet;
import java.util.Set;

public class CalculateScoreAfterPerformingInstructions3522 {
    public static void main(String[] args) {
        System.out.println(calculateScore(new String[]{"add", "jump", "add", "jump", "jump", "jump", "add"}, new int[]{12, 0, -12, 2, -3, -5, -14}));
//        System.out.println(calculateScore(new String[]{"jump", "add", "add", "jump", "add", "jump"}, new int[]{2, 1, 3, 1, -2, -3}));
    }

    public static long calculateScore(String[] instructions, int[] values) {
        long score = 0L;

        int len = values.length;
        Set<Integer> st = new HashSet<>(len);

        for (int i = 0; i < len; i++) {
            if (st.contains(i))
                break;

            st.add(i);

            String instruction = instructions[i];
            int value = values[i];

            switch (instruction) {
                case "add" -> {
                    score += value;
                }
                case "jump" -> {
                    i = i + value;

                    if (i >= len || i < 0 || st.contains(i))
                        return score;
                    i--;
                }
            }
        }

        return score;
    }
}