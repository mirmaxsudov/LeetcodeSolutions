package tasks;

import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicatesFromSortedArrayII80 {
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1, 1, 1, 2, 2, 3}) + " - " + 5);
        System.out.println(removeDuplicates(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}) + " - " + 7);
    }

    public static int removeDuplicates(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();

        for (int num : nums)
            mp.put(num, mp.getOrDefault(num, 0) + 1);

        int sum = 0;

        for (Map.Entry<Integer, Integer> en : mp.entrySet()) {
            if (en.getValue() >= 2) {
                sum += en.getValue();
            }
        }

        return sum;
    }
}