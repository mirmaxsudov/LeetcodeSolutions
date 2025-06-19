package tasks;

import java.util.HashMap;
import java.util.Map;

public class MaximumDifferenceBetweenEvenAndOddFrequencyI3442 {
    public static void main(String[] args) {

    }

    public static int maxDifference(String s) {
        int o = 0, e = Integer.MAX_VALUE;

        Map<Character, Integer> mp = new HashMap<>();

        for (char c : s.toCharArray())
            mp.put(c, mp.getOrDefault(c, 0) + 1);

        for (Map.Entry<Character, Integer> en : mp.entrySet()) {
            if ((en.getValue() & 1) == 0)
                e = Math.min(e, en.getValue());
            else
                o = Math.max(o, en.getValue());
        }

        return o - e;
    }
}