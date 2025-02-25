package tasks;

import java.util.ArrayList;
import java.util.List;

public class Subsets78 {
    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1, 2, 3}));
    }

    public static List<List<Integer>> subsets(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        helper(0, arr, res, subset);

        return res;
    }

    private static void helper(int i, int[] arr, List<List<Integer>> res, List<Integer> subset) {
        if (i == arr.length) {
            res.add(new ArrayList<>(subset));
            return;
        }

        subset.add(arr[i]);
        helper(i + 1, arr, res, subset);

        subset.removeLast();
        helper(i + 1, arr, res, subset);
    }
}