package tasks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SetMismatch645 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findErrorNums(new int[]{1, 2, 2, 4})));
        System.out.println(Arrays.toString(findErrorNums(new int[]{1, 1})));
        System.out.println(Arrays.toString(findErrorNums(new int[]{2, 2})));
        System.out.println(Arrays.toString(findErrorNums(new int[]{3, 2, 3, 4, 6, 5})));
    }

    public static int[] findErrorNums(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();

        for (int num : nums)
            mp.put(num, mp.getOrDefault(num, 0) + 1);

        Arrays.sort(nums);
        int num = 1;

        for (int c : nums) {
            if (mp.containsKey(num)) {
                if (mp.getOrDefault(num, 0) == 2) {
                    if (mp.containsKey(num - 1))
                        return new int[]{num, num + 1};
                    else
                        return new int[]{num, num - 1};
                }
                continue;
            }

            if (mp.getOrDefault(c, 0) == 2) {
                if (c == 1)
                    return new int[]{c, c + 1};

                if (mp.containsKey(c + 1))
                    return new int[]{c, c - 1};
                else if (!mp.containsKey(c - 1))
                    return new int[]{c, c - 1};
                else
                    return new int[]{c, c + 1};
            }
            num++;
        }

        return new int[]{-1, -1};
    }
}