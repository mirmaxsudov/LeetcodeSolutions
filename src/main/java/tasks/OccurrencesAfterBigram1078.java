package tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OccurrencesAfterBigram1078 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findOcurrences("alice is a good girl she is a good student", "a", "good")));
    }

    public static String[] findOcurrences(String text, String first, String second) {
        List<String> list = new ArrayList<>();
        String[] values = text.split(" ");

        for (int i = 0; i < values.length; i++)
            if (values[i].equals(first) && i + 2 < values.length && values[i + 1].equals(second))
                list.add(values[i + 2]);

        return list.toArray(new String[0]);
    }
}