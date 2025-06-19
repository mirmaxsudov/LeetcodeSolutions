package tasks;

import java.util.HashMap;
import java.util.Map;

public class FindValidPairOfAdjacentDigitsInString3438 {
    public static void main(String[] args) {
        System.out.println(findValidPair("2523533"));
    }

    public static String findValidPair(String s) {
        Map<Character, Integer> mp = new HashMap<>();

        for (char c : s.toCharArray())
            mp.put(c, mp.getOrDefault(c, 0) + 1);

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1))
                continue;

            if (mp.get(s.charAt(i)) == s.charAt(i) - '0' && mp.get(s.charAt(i + 1)) == s.charAt(i + 1) - '0') {
                return s.charAt(i) + "" + s.charAt(i + 1);
            }
        }

        return "";
    }
}