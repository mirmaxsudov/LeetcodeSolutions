package tasks;

import java.util.Arrays;
import java.util.Map;

public class LongestNiceSubstring1763 {
    public static void main(String[] args) {
        System.out.println(isNice("aAa"));
//        System.out.println(longestNiceSubstring("YazaAay"));
    }

    public static String longestNiceSubstring(String s) {
        for (int len = s.length(); len >= 1; len--)
            for (int i = 0; i + len <= s.length(); i++) {
                String substring = s.substring(i, i + len);
                if (isNice(substring))
                    return substring;
            }

        return "";
    }

    public static boolean isNice(String str) {
        int[] letters = new int[26];
        int checker = 0;

        for (char c : str.toCharArray()) {
            int index = Character.toLowerCase(c) - 'a';
            if (letters[index] == 32)
                continue;
            if (letters[index] == c)
                continue;
            if (letters[index] == 0) {
                letters[index] = c;
                checker++;
            } else {
                letters[index] = Math.abs(letters[index] - c);
                checker--;
            }
        }

        return checker == 0;
    }
}