package tasks;

import java.util.*;

public class RemoveLetterToEqualizeFrequency2423 {
    public static void main(String[] args) {
        System.out.println(equalFrequency("abcc")); // true
        System.out.println(equalFrequency("bac")); // true
        System.out.println(equalFrequency("abbcc")); // true
        System.out.println(equalFrequency("aazz")); // false
    }

    public static boolean equalFrequency(String word) {
        int[] counts = new int[26];

        for (char c : word.toCharArray())
            counts[c - 'a']++;

        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            counts[index]--;

            if (isEqual(counts))
                return true;

            counts[index]++;
        }

        return false;
    }

    private static boolean isEqual(int[] counts) {
        int c = 0;

        for (int count : counts) {
            if (count == 0)
                continue;
            else if (c == 0)
                c = count;
            else if (c != count)
                return false;
        }

        return true;
    }
}