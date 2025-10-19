package tasks;

import java.util.HashMap;
import java.util.Map;

public class RedistributeCharactersToMakeAllStringsEqual1897 {
    public static void main(String[] args) {

    }

    public static boolean makeEqualVer2(String[] words) {
        int[] chars = new int[26];

        for (String word : words)
            for (char c : word.toCharArray())
                chars[c - 'a']++;

        for (int count : chars)
            if (count % words.length != 0)
                return false;

        return true;
    }

    public static boolean makeEqual(String[] words) {
        Map<Character, Integer> mp = new HashMap<>();

        for (String word : words) {
            for (char ch : word.toCharArray()) {
                mp.put(ch, mp.getOrDefault(ch, 0) + 1);
            }
        }

        int count = mp.get(words[0].charAt(0));

        int len = words.length;
        if (count % len != 0)
            return false;

        for (Map.Entry<Character, Integer> en : mp.entrySet()) {
            int val = en.getValue();
            if (val != count) {
                if (val % len != 0)
                    return false;

                count = Math.max(count, val);
            }
        }

        return count % len == 0;
    }
}