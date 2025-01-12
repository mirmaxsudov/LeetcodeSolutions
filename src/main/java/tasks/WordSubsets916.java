package tasks;

import java.util.ArrayList;
import java.util.List;

public class WordSubsets916 {
    public static void main(String[] args) {

    }

    public static List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> res = new ArrayList<>();

        int s = 0, m = 0;

        for (String word : words1) {
            for (String sub : words2) {
                while (s < sub.length() && m < word.length()) {
                    if (sub.charAt(s) == word.charAt(m))
                        s++;
                    m++;
                }

                if (s == sub.length())
                    res.add(word);

                s = 0;
                m = 0;
            }
        }

        return res;
    }
}