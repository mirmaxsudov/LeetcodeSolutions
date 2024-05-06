package tasks;

import java.util.*;

public class LargestPositiveIntegerThatExistsWithItsNegative2441 {
    public static void main(String[] args) {
        System.out.println(findMaxK(
                new int[]{-1, -2, -3, 3}
        ));
        System.out.println(findMaxK(
                new int[]{-1, 10, 6, 7, -7, 1}
        ));
        System.out.println(findMaxK(
                new int[]{-10, 8, 6, 7, -2, -3}
        ));
    }

    private static int findMaxK(int[] nums) {
        Map<Integer, Set<Integer>> mp = new TreeMap<>(
                Comparator.reverseOrder()
        );

        for (int num : nums) {
            int abs = Math.abs(num);

            Set<Integer> set = mp.get(abs);

            if (set == null || set.isEmpty()) {
                HashSet<Integer> st = new HashSet<>();
                st.add(num);
                mp.put(abs, st);
                continue;
            }

            if (set.size() == 2) {
                continue;
            }

            set.add(num);
            mp.put(abs, set);
        }

        for (Map.Entry<Integer, Set<Integer>> en : mp.entrySet())
            if (en.getValue().size() == 2)
                return en.getKey();

        return -1;
    }
}