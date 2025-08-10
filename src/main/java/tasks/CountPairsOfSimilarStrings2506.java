package tasks;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CountPairsOfSimilarStrings2506 {
    public static void main(String[] args) {
        System.out.println(similarPairs(new String[]{"aba", "aabb", "abcd", "bac", "aabc"}));
        System.out.println(similarPairs(new String[]{"aabb", "ab", "ba"}));
        System.out.println(similarPairs(new String[]{"nba", "cba", "dba"}));
        System.out.println(similarPairs(new String[]{"zgtzytjkre", "jjzdbxyutj", "umghhnlihq", "mdxjukhqsm", "mqdplhuvqr", "xpdhateywu", "ugedwkxapc", "vjpryhictr"}));
    }

    public static int[] ids = new int[]{
            -13,
            314,
            6532,
            532,
            421,
            21,
            5,
            662,
            123,
            46,
            6356,
            9,
            857645,
            859,
            31245,
            5623576,
            456,
            7346574,
            67467,
            684564,
            2436653,
            234123,
            368775,
            84578,
            634421,
            73467,
    };

    public static int similarPairs(String[] words) {
        int res = 0;

        Map<String, Integer> wordIds = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                int id1 = wordIds.getOrDefault(words[i], -1);
                int id2 = wordIds.getOrDefault(words[j], -1);

                if (id1 == -1) {
                    id1 = getId(words[i]);
                    wordIds.put(words[i], id1);
                }

                if (id2 == -1) {
                    id2 = getId(words[j]);
                    wordIds.put(words[j], id2);
                }

                if (id1 == id2)
                    res++;
            }
        }

        return res;
    }

    public static int getId(String str) {
        int count = 0;
        Set<Character> st = new HashSet<>();

        for (char c : str.toCharArray()) {
            if (st.contains(c))
                continue;

            st.add(c);
            count += ids[c - 'a'];
        }

        return count;
    }
}