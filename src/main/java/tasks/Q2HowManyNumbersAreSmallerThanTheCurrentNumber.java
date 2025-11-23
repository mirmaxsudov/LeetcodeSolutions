package tasks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q2HowManyNumbersAreSmallerThanTheCurrentNumber {
    public static void main(String[] args) {

    }

    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] c = Arrays.copyOf(nums, nums.length);

        Arrays.sort(c);

        Map<Integer, Integer> m = new HashMap<>();

        for (int i = 0; i < c.length; i++)
            if (!m.containsKey(c[i]))
                m.put(c[i], i);

        // 8,1,2,2,3
        // After sort
        // 1,2,2,3,8

        for (int i = 0; i < nums.length; i++)
            nums[i] = m.get(nums[i]);

        return nums;
    }
}
