package tasks;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MinimumWindowSubstring {
    public static void main(String[] args) {

    }

    public static String minWindow(String s, String t) {
        if (s.length() < t.length())
            return "";

        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (char c : t.toCharArray())
            need.put(c, need.getOrDefault(c, 0) + 1);

        int have = 0, needCount = 0;

        for (Integer value : need.values())
            if (value > 0)
                needCount++;

        int l = 0, minLen = Integer.MAX_VALUE, start = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            window.put(ch, window.getOrDefault(ch, 0) + 1);

            if (need.getOrDefault(ch, 0) > 0 && Objects.equals(window.getOrDefault(ch, 0), need.getOrDefault(ch, 0)))
                have++;

            while (have == needCount) {
                if (i - l + 1 < minLen) {
                    minLen = i - l + 1;
                    start = l;
                }

                char leftChar = s.charAt(l);
                window.put(leftChar, window.getOrDefault(leftChar, 0) - 1);

                if (need.get(leftChar) > 0 && window.get(leftChar) < need.get(leftChar))
                    have--;

                l++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
