package tasks;

import java.util.HashMap;
import java.util.Map;

public class CountPairsOfSimilarStrings2506 {
    public static void main(String[] args) {

    }

    public static int similarPairs(String[] words) {
        int res = 0;

        Map<String, boolean[]> mp = new HashMap<>();

        for (String word : words) {
            boolean[] array = new boolean[26];

            for (char c : word.toCharArray())
                array[c - 'a'] = true;

            mp.put(word, array);
        }

        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                boolean[] vals1 = mp.get(words[i]);
                boolean[] vals2 = mp.get(words[j]);

                for (int a = 0; a < 26; a++)
                    if (!(vals1[a] && vals2[a]))
                        break;

                res++;
            }
        }

        return res;
    }
}