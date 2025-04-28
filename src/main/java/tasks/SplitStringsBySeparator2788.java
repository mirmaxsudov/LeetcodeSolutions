package tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

// ToDo: Solve later
public class SplitStringsBySeparator2788 {
    public static void main(String[] args) {
        System.out.println(splitWordsBySeparator(List.of("$easy$", "$problem$"), '$'));
        System.out.println(splitWordsBySeparator(List.of("one.two.three", "four.five", "six"), '.'));
        System.out.println(splitWordsBySeparator(List.of("|||"), '|'));
    }

    public static List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> r = new ArrayList<>();

        for (String word : words)
            r.addAll(split(word, separator));

        return r;
    }

    public static List<String> split(String s, char sp) {
        List<String> r = new ArrayList<>();
        int si = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == sp) {
                String sub = s.substring(si, i);

                if (!sub.isBlank()) {
                    r.add(sub);
                }

                si = i + 1;
            }
        }

        if (si != s.length()) {
            String sub = s.substring(si);

            if (!sub.isBlank())
                r.add(sub);
        }

        return r;
    }
}