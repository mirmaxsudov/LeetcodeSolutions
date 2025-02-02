package univer_lesson.anagram;

import java.util.ArrayList;
import java.util.List;

public class AnagramForArray {
    public static void main(String[] args) {
        List<Integer> list = List.of(
                1, 2, 3
        );

        List<String> helper = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        for (int num : list)
            sb.append(num);

        makeAnagram("", sb.toString(), helper);

        List<List<Integer>> res = new ArrayList<>();

        for (String val : helper) {
            List<Integer> r = new ArrayList<>();

            for (char c : val.toCharArray())
                r.add(c - '0');

            res.add(r);
        }

        System.out.println(res);
    }

    public static void makeAnagram(String res, String temp, List<String> helper) {
        int length = temp.length();

        if (length == 0) {
            helper.add(res);
            return;
        }

        for (int i = 0; i < length; i++)
            makeAnagram(res + temp.charAt(i), temp.substring(0, i) + temp.substring(i + 1, length), helper);
    }
}