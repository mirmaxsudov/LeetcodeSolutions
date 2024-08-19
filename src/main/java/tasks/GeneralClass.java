package tasks;

import java.util.*;

public class GeneralClass {
    public static void main(String[] args) {
    }

    public int numWaterBottles(int numBottles, int numExchange) {
        int result = numBottles;

        while (numBottles >= numExchange) {
            result += numBottles / numExchange;
            numBottles = (numBottles / numExchange) + (numBottles % numExchange);
        }

        return result;
    }

    public int minOperations(String[] logs) {
        //     d1/           ../        ./
        int parent = 0;

        for (String log : logs) {
            if (log.equals("./"))
                continue;
            else if (log.equals("../") && parent == 0)
                continue;

            if (log.equals("../")) {
                parent--;
            } else if (!log.contains(".") && log.endsWith("/")) {
                parent++;
            }
        }

        return parent;
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums1)
            set.add(num);

        List<Integer> nums = new ArrayList<>();
        Set<Integer> without = new LinkedHashSet<>();

        for (int num : nums2)
            if (set.contains(num) && !without.contains(num)) {
                nums.add(num);
                without.add(num);
            }

        return nums.stream().mapToInt(Integer::intValue).toArray();
    }
}
