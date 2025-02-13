package tasks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaximumNumberOfPairsInArray2341 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(numberOfPairsVer2(new int[]{1, 3, 2, 1, 3, 2, 2})));
        System.out.println(Arrays.toString(numberOfPairsVer2(new int[]{1, 1})));
        System.out.println(Arrays.toString(numberOfPairsVer2(new int[]{0})));
    }

    public static int[] numberOfPairsVer2(int[] nums) {
        int[] helper = new int[101];

        for (int num : nums)
            helper[num]++;

        int p = 0, l = 0;

        for (int val : helper) {
            if (val == 0)
                continue;

            p += val / 2;
            l += val % 2;
        }

        return new int[]{p, l};
    }

    public static int[] numberOfPairs(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();

        for (int num : nums)
            mp.put(num, mp.getOrDefault(num, 0) + 1);

        int cP = 0, cL = 0;

        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            cP += entry.getValue() / 2;
            cL += entry.getValue() % 2;
        }

        return new int[]{cP, cL};
    }
}