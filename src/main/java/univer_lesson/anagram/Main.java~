package univer_lesson.anagram;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<String> anagrams = new ArrayList<>();

    public static void main(String[] args) {
        anagram("", "Mirmaxsudov");

        System.out.println(1 * 2 * 3 * 4 * 5 * 6 * 7 * 8 * 9 * 10 * 11);

        System.out.println("anagrams = " + anagrams.size());
    }

    public static void anagram(String res, String temp) {
        int length = temp.length();

        if (length == 0) {
            anagrams.add(res);
//            System.out.println(res);
            return;
        }

        for (int i = 0; i < length; i++)
            anagram(res + temp.charAt(i), temp.substring(0, i) + temp.substring(i + 1, length));
    }
}