package tasks;

import java.util.HashMap;
import java.util.Map;

public class CheckWhetherTwoStringsAreAlmostEquivalent2068 {
    public static void main(String[] args) {
        System.out.println(checkAlmostEquivalent("aaaa", "bccb"));
        System.out.println(checkAlmostEquivalent("abcdeef", "abaaacc"));
        System.out.println(checkAlmostEquivalent("cccddabba", "babababab"));
    }

    public static boolean checkAlmostEquivalent(String word1, String word2) {
        Map<Character, Integer> countOfChars = new HashMap<>();
        boolean[] isExists = new boolean[26];

        for (int i = 0; i < word1.length(); i++) {
            countOfChars.put(word1.charAt(i), countOfChars.getOrDefault(word1.charAt(i), 0) + 1);
            countOfChars.put(word2.charAt(i), countOfChars.getOrDefault(word2.charAt(i), 0) - 1);

            isExists[word1.charAt(i) - 'a'] = true;
            isExists[word2.charAt(i) - 'a'] = true;
        }

        for (int i = 0; i < isExists.length; i++) {
            if (!isExists[i])
                continue;

            int abs = Math.abs(countOfChars.get((char) (i + 'a')));
            if (!(abs <= 3 && abs >= 0))
                return false;
        }

        return true;
    }
}