package tasks;

import java.util.HashSet;
import java.util.Set;

public class CountOfSubstringsContainingEveryVowelAndKConsonantsII {
    public static void main(String[] args) {
        System.out.println(countOfSubstrings("aeioqq", 1));
        System.out.println(countOfSubstrings("aeiou", 0));
        System.out.println(countOfSubstrings("ieaouqqieaouqq", 1));
    }

    public static long countOfSubstrings(String word, int k) {
        int dif = 5 + k;
        int result = 0;

        for (int i = 0; i < word.length() - dif + 1; i++) {
            String sub = word.substring(i, i + dif);
            Set<Character> vowels = new HashSet<>();
            int count = 0;

            for (char c : sub.toCharArray()) {
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
                    vowels.add(c);
                else
                    count++;
            }

            if (vowels.size() == 5 && count == k)
                result++;

        }

        return result;
    }
}