package tasks;

import java.util.HashMap;
import java.util.Map;

public class CountVowelSubstringsOfAString2062 {
    final static Map<Character, Boolean> VOWELS = new HashMap<>(
            Map.of(
                    'a', true,
                    'e', true,
                    'i', true,
                    'o', true,
                    'u', true
            )
    );

    public static void main(String[] args) {
        System.out.println(countVowelSubstrings("aeiouu"));
        System.out.println(countVowelSubstrings("unicornarihan"));
        System.out.println(countVowelSubstrings("cuaieuouac"));
        System.out.println(countVowelSubstrings("poazaeuioauoiioaouuouaui"));
    }

    public static int countVowelSubstrings(String word) {
        int count = 0;

        for (int i = 0; i < word.length(); i++) {
            final char ch = word.charAt(i);

            if (VOWELS.containsKey(ch)) {
                int consonant = -1;

                for (int j = i + 1; j < word.length(); j++) {
                    if (!VOWELS.containsKey(word.charAt(j))) {
                        consonant = j;
                        break;
                    }
                }

                if (consonant == -1)
                    consonant = word.length();

                if (consonant - i <= 4) {
                    i = consonant;
                    continue;
                }

                count += getInnerCount(word.substring(i, consonant));
                i = consonant + 1;
            }
        }

        return count;
    }

    private static int getInnerCount(String subVowels) {
        int innerCount = 0;

        int len = subVowels.length();

        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                String sub = subVowels.substring(i, j + 1);

                if (sub.length() < 5)
                    continue;

                boolean isA = false, isE = false, isI = false, isO = false, isU = false;

                for (char c : sub.toCharArray()) {
                    if (c == 'a') {
                        isA = true;
                    } else if (c == 'e') {
                        isE = true;
                    } else if (c == 'i') {
                        isI = true;
                    } else if (c == 'o') {
                        isO = true;
                    } else if (c == 'u') {
                        isU = true;
                    }

                    if (isA && isE && isI && isO && isU)
                        break;
                }

                if (isA && isE && isI && isO && isU) {
                    innerCount++;
                }
            }
        }

        return innerCount;
    }
}