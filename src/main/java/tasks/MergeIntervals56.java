package tasks;

import java.util.*;

public class MergeIntervals56 {
    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1, 3, 4}));
    }

    public static List<List<Integer>> subsets(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        generate(0, arr, res, subset);

        return res;
    }

    private static void generate(int i, int[] arr, List<List<Integer>> res, List<Integer> subset) {
        if (i == arr.length) {
            res.add(new ArrayList<>(subset));
            return;
        }

        subset.add(arr[i]);
        generate(i + 1, arr, res, subset);

        subset.removeLast();
        generate(i + 1, arr, res, subset);
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        System.out.println("intervals = " + Arrays.deepToString(intervals));

        List<int[]> merged = new ArrayList<>();
        int[] prev = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];

            if (interval[0] <= prev[1]) {
                prev[1] = Math.max(prev[1], interval[1]);
            } else {
                merged.add(prev);
                prev = interval;
            }
        }

        merged.add(prev);

        return merged.toArray(new int[merged.size()][]);
    }
}