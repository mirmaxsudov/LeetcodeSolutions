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
    }

    public static final Set<Character> REGEX_SPECIAL_CHARS = Set.of(
            '\\', '^', '$', '.', '|', '?', '*', '+', '(', ')', '[', ']', '{', '}'
    );

    public static List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> r = new ArrayList<>();

        String regex = REGEX_SPECIAL_CHARS.stream()
                .map(c -> "\\" + c)
                .map(Pattern::quote)
                .collect(Collectors.joining("|"));

        for (String word : words)
            r.addAll(split(word, regex));

        return r;
    }

    public static List<String> split(String s, String sp) {
        List<String> r = new ArrayList<>();

        for (String word : s.split(sp))
            if (!word.isBlank())
                r.add(word);

        return r;
    }
}