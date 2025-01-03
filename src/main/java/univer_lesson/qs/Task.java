package univer_lesson.qs;

import java.util.HashMap;
import java.util.Map;

public class Task {
    public static void main(String[] args) {
    }

    public static long check(String str, String target) {
        long res = 0;
        boolean[] isUsed = new boolean[26];
        Map<Character, Integer> collector = new HashMap<>();

        for (char ch : target.toCharArray())
            collector.put(ch, collector.getOrDefault(ch, 0) + 1);

        for (char c : str.toCharArray()) {
            if (isUsed[c - 'a'])
                continue;

            isUsed[c - 'a'] = true;
            res += collector.get(c);
        }

        return res;
    }
}