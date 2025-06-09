package tasks;

import java.util.*;

public class IntersectionOfMultipleArrays2248 {
    public static void main(String[] args) {

    }

    public static List<Integer> intersection(int[][] nums) {
        Map<Integer, Integer> mp = new HashMap<>();

        for (int[] arr : nums)
            for (int num : arr)
                mp.put(num, mp.getOrDefault(num, 0) + 1);

        List<Integer> list = new ArrayList<>();
        int length = nums.length;

        for (Map.Entry<Integer, Integer> entry : mp.entrySet())
            if (entry.getValue() == length)
                list.add(entry.getKey());

        Collections.sort(list);

        return list;
    }
}
