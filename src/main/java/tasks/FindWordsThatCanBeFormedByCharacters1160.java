package tasks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindWordsThatCanBeFormedByCharacters1160 {
    public static void main(String[] args) {
        String[] words = {"cat", "bt", "hat", "tree"};
        String chars = "atach";

        System.out.println(countCharacters(words, chars));

        String[] words2 = {"hello", "world", "leetcode"};
        String chars2 = "welldonehoneyr";

        System.out.println(countCharacters(words2, chars2));
    }

    public static int countCharacters(String[] words, String chars) {
        int res = 0;

        Map<Character, Integer> mp = new HashMap<>();

        for (char c : chars.toCharArray())
            mp.put(c, mp.getOrDefault(c, 0) + 1);

        int[] values = new int[28];

        label:
        for (String word : words) {
            Arrays.fill(values, 0);
            for (char c : word.toCharArray()) {
                int count = mp.getOrDefault(c, 0) - values[c - 'a'];

                if (count <= 0)
                    continue label;

                values[c - 'a']++;
            }

            res += word.length();
        }

        return res;
    }
}