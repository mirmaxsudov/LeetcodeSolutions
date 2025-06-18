package tasks;

import java.util.Map;

public class FindMostFrequentVowelAndConsonant3541 {
    public static void main(String[] args) {

    }

    public static int maxFreqSum(String s) {
        int[] values = new int[26];
        int v, c;
        v = c = 0;

        for (char ch : s.toCharArray()) {
            int val = ++values[ch - 'a'];

            if (ch == 'a' || ch == 'i' || ch == 'u' || ch == 'o' || ch == 'e')
                v = Math.max(v, val);
            else
                c = Math.max(c, val);
        }

        return v + c;
    }
}