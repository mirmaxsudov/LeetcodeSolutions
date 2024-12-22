package tasks;

import java.util.Map;

public class ValidWord3136 {
    public static void main(String[] args) {

    }

    public static boolean isValid(String word) {
        boolean isVowel, isConstant;
        isConstant = isVowel = false;

        Map<Character, Boolean> VOWELS = Map.of(
                'a', true, 'e', true, 'i', true, 'o', true, 'u', true,
                'A', true, 'E', true, 'I', true, 'O', true, 'U', true
        );

        if (word.length() < 3)
            return false;

        for (char c : word.toCharArray()) {
            if (isConstant && isVowel)
                return true;

            if (Character.isLetter(c)) {
                if (!isVowel && VOWELS.containsKey(c))
                    isVowel = true;

                if (!isConstant && !VOWELS.containsKey(c))
                    isConstant = true;
            } else if (Character.isDigit(c)) {
                return false;
            }
        }

        return isConstant && isVowel;
    }
}