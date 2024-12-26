package tasks;

import java.util.LinkedList;
import java.util.List;

public class SplitStringsBySeparator2788 {
    public static void main(String[] args) {
        System.out.println(splitWordsBySeparator(List.of("one.two.three", "four.five", "six"), '.'));
        System.out.println(splitWordsBySeparator(List.of("$easy$", "$problem$"), '$'));
        System.out.println(splitWordsBySeparator(List.of("|||"), '|'));
    }

    public static List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> r = new LinkedList<>();

        for (String word : words) {
            int si = 0;
            for (int i = 0; i < word.toCharArray().length; i++) {
                if (word.charAt(i) == separator) {
                    if (i - si == 0)
                        continue;

                    if (word.charAt(si) == separator)
                        r.add(word.substring(si + 1, i));
                    else
                        r.add(word.substring(si, i));

                    si = i;
                }
            }

            if (si != word.length() - 1) {
                if (word.charAt(si) == separator)
                    r.add(word.substring(si + 1));
                else
                    r.add(word.substring(si));
            }
        }

        return r;
    }
}