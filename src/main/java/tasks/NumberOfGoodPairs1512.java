package tasks;

import java.util.HashMap;
import java.util.Map;

public class NumberOfGoodPairs1512 {
    public static void main(String[] args) {

    }

    public static int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();

        for (int num : nums)
            mp.put(num, mp.getOrDefault(num, 0) + 1);

        int count = 0;

        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            int value = entry.getValue();
            count += (value * (value - 1)) / 2;
        }

        return count;
    }
}