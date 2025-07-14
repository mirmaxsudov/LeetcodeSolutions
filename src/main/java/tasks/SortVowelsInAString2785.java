package tasks;

import java.util.*;

public class SortVowelsInAString2785 {
    public static void main(String[] args) {
        System.out.println(sortVowels("lEetcOde"));
    }

    public static String sortVowels(String s) {
        char[] chars = s.toCharArray();

        Map<Character, Integer> mp = new HashMap<>();
        List<Character> list = new ArrayList<>();

        for (char c : chars)
            if (isVowel(c)) {
                mp.put(c, mp.getOrDefault(c, 0) + 1);
                if (!list.contains(c))
                    list.add(c);
            }

        Collections.sort(list);
        int listIndex = 0;

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (!isVowel(c))
                continue;

            Character character = list.get(listIndex);
            chars[i] = character;
            if (mp.get(character) - 1 == 0) {
                mp.remove(character);
                listIndex++;
            } else
                mp.put(character, mp.get(character) - 1);
        }

        return new String(chars);
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}