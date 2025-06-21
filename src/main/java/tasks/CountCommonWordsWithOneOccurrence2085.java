package tasks;

import java.util.HashMap;
import java.util.Map;

public class CountCommonWordsWithOneOccurrence2085 {
    public static void main(String[] args) {

    }

    public static int countWords(String[] words1, String[] words2) {
        int res = 0;

        Map<String, Integer> mp1 = new HashMap<>();
        Map<String, Integer> mp2 = new HashMap<>();

        for (String word : words1)
            mp1.put(word, mp1.getOrDefault(word, 0) + 1);

        for (String word : words2)
            mp2.put(word, mp2.getOrDefault(word, 0) + 1);

        if (mp1.size() >= mp2.size()) {
            for (Map.Entry<String, Integer> en : mp2.entrySet())
                if (en.getValue() == 1 && mp1.getOrDefault(en.getKey(), 0) == 1)
                    res++;
        } else
            for (Map.Entry<String, Integer> en : mp1.entrySet())
                if (en.getValue() == 1 && mp2.getOrDefault(en.getKey(), 0) == 1)
                    res++;

        return res;
    }
}
