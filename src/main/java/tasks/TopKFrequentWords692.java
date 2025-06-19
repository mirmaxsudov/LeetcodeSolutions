package tasks;

import java.util.*;

public class TopKFrequentWords692 {
    public static void main(String[] args) {
        System.out.println(topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2));
    }

    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> mp = new HashMap<>();

        for (String word : words)
            mp.put(word, mp.getOrDefault(word, 0) + 1);

        PriorityQueue<Pair> pq = new PriorityQueue<>(((o1, o2) -> {
            if (o1.count == o2.count)
                return o1.pair.compareTo(o2.pair);

            return Integer.compare(o2.count, o1.count);
        }));

        for (Map.Entry<String, Integer> en : mp.entrySet()) {
            Pair pair = new Pair();
            pair.pair = en.getKey();
            pair.count = en.getValue();
            pq.add(pair);
        }

        List<String> res = new ArrayList<>();

        while (k != 0) {
            res.add(pq.poll().pair);
            k--;
        }

        return res;
    }

    static class Pair {
        String pair;
        int count;
    }
}