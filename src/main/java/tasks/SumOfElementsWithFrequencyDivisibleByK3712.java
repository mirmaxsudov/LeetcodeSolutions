package tasks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SumOfElementsWithFrequencyDivisibleByK3712 {
    public static void main(String[] args) {
        System.out.println(sumDivisibleByKVer2(new int[]{1, 2, 2, 3, 3, 3, 3, 4}, 2));
    }

    public static int sumDivisibleByKVer2(int[] nums, int k) {
        int max = 0;

        for (int num : nums)
            max = Math.max(max, num);

        int[] helper = new int[max];

        for (int num : nums)
            helper[num - 1]++;

        int sum = 0;

        for (int i = 0; i < helper.length; i++)
            if (helper[i] % k == 0)
                sum += ((i + 1) * helper[i]);

        return sum;
    }

    public static int sumDivisibleByK(int[] nums, int k) {
        int sum = 0;

        Map<Integer, Integer> mp = new HashMap<>();

        for (int num : nums)
            mp.put(num, mp.getOrDefault(num, 0) + 1);

        for (Map.Entry<Integer, Integer> e : mp.entrySet())
            if (e.getValue() == k || e.getValue() % k == 0)
                sum += (e.getKey() * e.getValue());

        return sum;
    }
}