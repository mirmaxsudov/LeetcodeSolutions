package tasks;

import java.util.*;

public class FindMissingElements3731 {
    public static void main(String[] args) {

    }

    public static List<Integer> findMissingElements(int[] nums) {
        Set<Integer> st = new HashSet<>();
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        List<Integer> list = new ArrayList<>();

        for (int num : nums) {
            min = Math.min(num, min);
            max = Math.max(num, max);
            st.add(num);
        }

        for (int i = min + 1; i < max; i++)
            if (!st.contains(i))
                list.add(i);

        return list;
    }
}
