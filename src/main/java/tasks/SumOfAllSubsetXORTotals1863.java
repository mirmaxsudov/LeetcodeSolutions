package tasks;

import java.util.ArrayList;
import java.util.List;

public class SumOfAllSubsetXORTotals1863 {
    public static void main(String[] args) {
    }

    public static void gSubs(int[] nums, int index, List<Integer> crt, List<List<Integer>> res) {
        res.add(new ArrayList<>(crt));

        for (int i = index; i < nums.length; i++) {
            crt.add(nums[i]);
            gSubs(nums, i + 1, crt, res);
            crt.removeLast();
        }
    }

    public int subsetXORSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        gSubs(nums, 0, new ArrayList<>(), res);

        int result = 0;

        for (List<Integer> re : res) {
            int helper = 0;
            for (int num : re) {
                helper ^= num;
            }

            result += helper;
        }

        return result;
    }
}