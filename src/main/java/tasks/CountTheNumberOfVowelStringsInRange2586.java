package tasks;

import java.util.Set;

public class CountTheNumberOfVowelStringsInRange2586 {
    public static void main(String[] args) {

    }

    public static int vowelStrings(String[] words, int left, int right) {
        Set<Character> vowels = Set.of('a', 'e', 'u', 'i', 'o');
        int r = 0;

        for (int i = left; i <= right; i++)
            if (vowels.contains(words[i].charAt(0)) && vowels.contains(words[i].charAt(words[i].length() - 1)))
                r++;

        return r;
    }
}