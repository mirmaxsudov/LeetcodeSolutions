package tasks;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueNumberOfOccurrences1207 {
    public static void main(String[] args) {

    }

    public static boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> mp = new HashMap<>();
        Set<Integer> st = new HashSet<>();

        for (int num : arr)
            mp.put(num, mp.getOrDefault(num, 0) + 1);

        for (Map.Entry<Integer, Integer> e : mp.entrySet()) {
            if (st.contains(e.getValue()))
                return false;
            st.add(e.getValue());
        }

        return true;
    }
}