package tasks;

import java.util.*;

public class FindTheMostCommonResponse3527 {
    public static void main(String[] args) {
        System.out.println(findCommonResponse(List.of(
                List.of("good", "ok", "good", "ok"),
                List.of("ok", "bad", "good", "ok", "ok"),
                List.of("good"),
                List.of("bad")
        )));
    }

    public static String findCommonResponse(List<List<String>> data) {
        Map<String, Integer> mp = new HashMap<>();
        Set<String> used = new HashSet<>();

        for (List<String> responses : data) {
            for (String response : responses) {
                if (used.contains(response))
                    continue;

                used.add(response);
                mp.put(response, mp.getOrDefault(response, 0) + 1);
            }

            used.clear();
        }

        int max = Integer.MIN_VALUE;
        List<String> helper = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : mp.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                helper.clear();
                helper.add(entry.getKey());
            } else if (entry.getValue() == max)
                helper.add(entry.getKey());
        }

        if (helper.size() == 1)
            return helper.getFirst();

        String smallest = helper.getFirst();

        for (String word : helper)
            if (word.compareTo(smallest) < 0)
                smallest = word;

        return smallest;
    }
}