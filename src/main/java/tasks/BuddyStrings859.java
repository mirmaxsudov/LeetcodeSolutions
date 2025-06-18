package tasks;

import java.util.HashMap;
import java.util.Map;

public class BuddyStrings859 {
    public static void main(String[] args) {
        System.out.println(buddyStrings("ab", "ba"));
        System.out.println(buddyStrings("ab", "ab"));
        System.out.println(buddyStrings("aa", "aa"));
        System.out.println(buddyStrings("aaab", "aaab"));
    }

    public static boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length())
            return false;

        Map<Character, Integer> mp1 = new HashMap<>();
        Map<Character, Integer> mp2 = new HashMap<>();

        for (char c : s.toCharArray())
            mp1.put(c, mp1.getOrDefault(c, 0) + 1);

        for (char c : goal.toCharArray())
            mp2.put(c, mp2.getOrDefault(c, 0) + 1);

        if (mp1.size() != mp2.size())
            return false;

        boolean isEvenExists = false;

        for (Map.Entry<Character, Integer> e : mp1.entrySet()) {
            if (!e.getValue().equals(mp2.getOrDefault(e.getKey(), -1)))
                return false;
            else {
                if (e.getValue() >= 2)
                    isEvenExists = true;
            }
        }

        int i1 = -1, i2 = -1;
        char c1Ver1 = '.', c1Ver2 = '.', c2Ver1 = '.', c2Ver2 = '.';

        int len = s.length();

        for (int i = 0; i < len; i++) {
            char ch1 = s.charAt(i);
            char ch2 = goal.charAt(i);

            if (ch1 != ch2) {
                if (i1 == -1) {
                    i1 = i;
                    c1Ver1 = ch1;
                    c1Ver2 = ch2;
                } else if (i2 == -1) {
                    i2 = i;
                    c2Ver1 = ch1;
                    c2Ver2 = ch2;
                } else
                    return false;
            }
        }

        if (i1 == -1 || i2 == -1)
            return isEvenExists;

        return c1Ver1 == c2Ver2 && c1Ver2 == c2Ver1;
    }
}