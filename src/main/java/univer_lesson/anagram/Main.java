package univer_lesson.anagram;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<String> anagrams = new ArrayList<>();

    public static void anagram(String res, String temp) {
        int length = temp.length();

        if (length == 0) {
            anagrams.add(res);
            return;
        }

        for (int i = 0; i < length; i++)
            anagram(res + temp.charAt(i), temp.substring(0, i) + temp.substring(i + 1, length));
    }

    public static void main(String[] args) {
        anagram("", "Mirmaxsudov");
        System.out.println("anagrams = " + anagrams.size());
    }
}