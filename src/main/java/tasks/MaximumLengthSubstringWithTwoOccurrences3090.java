package tasks;

import java.util.HashMap;
import java.util.Map;

public class MaximumLengthSubstringWithTwoOccurrences3090 {
    public static void main(String[] args) {
        System.out.println(maximumLengthSubstring("bcbbbcba") + " - " + 4);
        System.out.println(maximumLengthSubstring("aaaa") + " - " + 2);
        System.out.println(maximumLengthSubstring("abcd") + " - " + 0);
        System.out.println(maximumLengthSubstring("eebadadbfa") + " - " + 9);
    }

    public static int maximumLengthSubstring(String s) {
        int[] vals = new int[26];

        for (char c : s.toCharArray())
            vals[c - 'a']++;

        int len = s.length();

        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                if (isValid(vals))
                    return len - j;
            }

            
        }

        return 0;
    }

    private static boolean isValid(int[] vals) {
        for (int val : vals)
            if (val >= 2)
                return false;
        return true;
    }
}