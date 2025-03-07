package tasks;

import java.util.HashMap;
import java.util.Map;

public class CountNumberOfPairsWithAbsoluteDifferenceK2006 {
    public static void main(String[] args) {

    }

    public static int countKDifferenceVer2(int[] nums, int k) {
        int res = 0;
        Map<Integer, Integer> mp = new HashMap<>();

        for (int num : nums) {
            mp.put(num, mp.getOrDefault(num, 0) + 1);
            res += mp.getOrDefault(num - k, 0) + mp.getOrDefault(num + k, 0);
        }

        return res;
    }

    public static int countKDifference(int[] nums, int k) {
        int res = 0;

        for (int i = 0; i < nums.length; i++)
            for (int j = i + 1; j < nums.length; j++)
                if (Math.abs(nums[i] - nums[j]) == k)
                    res++;

        return res;
    }
}