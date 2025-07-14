package tasks;

import java.util.ArrayList;
import java.util.List;

public class HashDividedString3271 {
    public static void main(String[] args) {
        System.out.println(stringHash("abcd", 2));
        System.out.println(stringHash("abcdvv", 2));
        System.out.println(stringHash("mxz", 3));
    }

    public static String stringHash(String s, int k) {
        if (s.length() == 1 || k == 1)
            return s;

        int count = s.length() / k;
        char[] chars = new char[count];
        int charsIndex = 0;
        int index = 0;

        while (count-- != 0) {
            String sub = s.substring(index, index + k);
            int sum = 0;

            for (char c : sub.toCharArray())
                sum += c - 'a';

            chars[charsIndex++] = (char) (sum % 26 + 'a');
            index += k;
        }

        return new String(chars);
    }
}