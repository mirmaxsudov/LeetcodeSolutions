package tasks;

import java.util.*;

public class FindScoreOfAnArrayAfterMarkingAllElements2593 {
    public static void main(String[] args) {
        System.out.println(findScore2(new int[]{2, 1, 3, 4, 5, 2}));
//        System.out.println(findScore(new int[]{3}));
    }

    public static long findScore2(int[] nums) {
        long res = 0;
        for (int i = 0; i < nums.length; i += 2) {
            int start = i;
            while (i + 1 < nums.length && nums[i + 1] < nums[i]) {
                i++;
            }
            for (int j = i; j >= start; j -= 2) {
                res += nums[j];
            }
        }
        return res;
    }

    public static long findScore(int[] nums) {
        if (nums.length <= 1)
            return nums[0];

        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>();

        for (int i = 0; i < nums.length; i++)
            entries.add(new AbstractMap.SimpleEntry<>(i, nums[i]));

        entries.sort(Comparator.comparingInt(Map.Entry::getValue));

        int countMarked = 0;
        long sum = 0;

        boolean[] isMarked = new boolean[nums.length];

        for (int i = 0; i < nums.length; i++)
            isMarked[i] = false;

        for (Map.Entry<Integer, Integer> entry : entries) {
            int index = entry.getKey();

            if (isMarked[index]) {
                continue;
            }

            if (countMarked == nums.length)
                return sum;

            isMarked[index] = true;
            countMarked += 1;
            sum += entry.getValue();

            if (index == 0) {
                isMarked[index + 1] = true;
            } else if (index == nums.length - 1) {
                isMarked[index - 1] = true;
            } else {
                isMarked[index + 1] = true;
                isMarked[index - 1] = true;
            }
        }

        return sum;
    }
}