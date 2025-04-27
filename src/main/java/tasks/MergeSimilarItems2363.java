package tasks;

import java.util.*;

public class MergeSimilarItems2363 {
    public static void main(String[] args) {

    }

    static class Pair implements Comparable<Integer> {
        Integer val;
        int[] item;

        public Pair(int i, int[] item) {
            this.val = i;
            this.item = item;
        }

        @Override
        public int compareTo(Integer val) {
            return this.val.compareTo(val);
        }
    }

    public static List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        List<List<Integer>> r = new ArrayList<>();

        TreeSet<Pair> pairs = new TreeSet<>(Comparator.comparing(a -> a.val));
        Set<Integer> used = new HashSet<>();

        for (int[] item : items1) {
            for (int[] item2 : items2)
                if (item[0] == item2[0]) {
                    item[1] += item2[1];
                    used.add(item[0]);
                    break;
                }

            pairs.add(new Pair(item[0], item));
        }

        for (int[] item : items2)
            if (!used.contains(item[0]))
                pairs.add(new Pair(item[0], item));

        for (Pair pair : pairs)
            r.add(List.of(pair.item[0], pair.item[1]));

        return r;
    }
}