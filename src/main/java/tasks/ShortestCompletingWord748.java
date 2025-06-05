package tasks;

import java.util.HashMap;
import java.util.Map;

public class ShortestCompletingWord748 {
    public static void main(String[] args) {
        System.out.println(shortestCompletingWord("1s3 PSt", new String[]{"step", "steps", "stripe", "stepple"}));
    }

    public static String shortestCompletingWord(String licensePlate, String[] words) {
        StringBuilder sb = new StringBuilder();
        boolean isFirst = true;

        for (String word : words) {
            if (isValid(word.toLowerCase(), licensePlate.toLowerCase())) {
                if (isFirst) {
                    sb.append(word);
                    isFirst = false;
                } else {
                    if (sb.length() > word.length())
                        sb = new StringBuilder(word);
                }
            }
        }

        return sb.toString();
    }

    private static boolean isValid(String word, String licensePlate) {
        Map<Character, Integer> mp = new HashMap<>();

        for (char c : licensePlate.toCharArray())
            mp.put(c, mp.getOrDefault(c, 0) + 1);

        for (char c : word.toCharArray())
            mp.put(c, mp.getOrDefault(c, 0) - 1);

        for (char c : licensePlate.toCharArray())
            if (Character.isLetter(c))
                if (mp.getOrDefault(c, 10) > 0)
                    return false;

        return true;
    }
}