package tasks;

import java.util.HashMap;
import java.util.Map;

public class SumOfUniqueElements1748 {
    public static void main(String[] args) {

    }

    public static int sumOfUnique2(int[] nums) {
        int res = 0;

        for (int num : nums)
            res ^= num;

        return res;
    }

    public static int sumOfUnique(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();

        for (int num : nums)
            mp.put(num, mp.getOrDefault(num, 0) + 1);

        int sum = 0;

        for (Map.Entry<Integer, Integer> entry : mp.entrySet())
            if (entry.getValue() == 1)
                sum += entry.getKey();

        return sum;
    }
}
