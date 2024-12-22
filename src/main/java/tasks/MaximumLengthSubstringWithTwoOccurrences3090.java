package tasks;

import java.util.Map;

public class MaximumLengthSubstringWithTwoOccurrences3090 {
    public static void main(String[] args) {
        System.out.println(maximumLengthSubstring("bcbbbcba") + " - " + 4);
        System.out.println(maximumLengthSubstring("aaaa") + " - " + 2);
//        System.out.println(maximumLengthSubstring("abcd") + " - " + 0);
        System.out.println(maximumLengthSubstring("eebadadbfa") + " - " + 9);
    }

    public static int maximumLengthSubstring(String s) {
        int max = s.length();
        int n = s.length();

        for (int len = n; len >= 2; len--) {
            for (int i = 0; i <= n - len; i++) {
                byte[] chars = new byte[26];
                String str = s.substring(i, i + len);

                for (int k = 0; k < str.length(); k++) {
                    chars[str.charAt(k) - 'a']++;
                }

                int count = 0;

                for (byte aChar : chars) {
                    if (aChar > 1) {
                        count++;
                    }
                }

                System.out.println("count = " + count);

                if (count < 2) {
                    return str.length();
                }

            }
        }

        return 0;
    }
}