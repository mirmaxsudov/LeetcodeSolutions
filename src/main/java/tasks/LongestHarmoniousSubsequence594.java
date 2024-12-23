package tasks;

import java.util.*;

public class LongestHarmoniousSubsequence594 {
    public static void main(String[] args) {
        System.out.println(findLHS(new int[]{1, 3, 2, 2, 5, 2, 3, 7}));
    }

    public static int findLHS(int[] nums) {
        int max = 0;

        Set<Integer> st = new TreeSet<>();

        for (int num : nums)
            st.add(num);

        int[] sorted = new int[st.size()];
        int index = 0;

        for (int num : st)
            sorted[index++] = num;

        Map<Integer, Integer> mp = new HashMap<>();

        for (int num : nums) mp.put(num, mp.getOrDefault(num, 0) + 1);

        for (int i = 0; i < sorted.length - 1; i++) {
            int f = sorted[i];
            int s = sorted[i + 1];

            if (Math.abs(f - s) != 1) {
                continue;
            }

            max = Math.max(max, (mp.get(f) + mp.get(s)));
        }

        return max;
    }
}