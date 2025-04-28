package tasks;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindTheDistinctDifferenceArray2670 {
    public static void main(String[] args) {

    }

    public static int[] distinctDifferenceArray(int[] nums) {
        Map<Integer, Integer> ps = new HashMap<>();
        Map<Integer, Integer> ss = new HashMap<>();

        ps.put(nums[0], 1);

        for (int i = 1; i < nums.length; i++)
            ss.put(nums[i], ss.getOrDefault(nums[i], 0) + 1);

        int[] r = new int[nums.length];
        r[0] = ps.size() - ss.size();

        for (int i = 1; i < nums.length; i++) {
            int c = ss.get(nums[i]);
            if (c == 1)
                ss.remove(nums[i]);
            else
                ss.put(nums[i], c - 1);

            ps.put(nums[i], 1);
            r[i] = ps.size() - ss.size();
        }

        return r;
    }
}