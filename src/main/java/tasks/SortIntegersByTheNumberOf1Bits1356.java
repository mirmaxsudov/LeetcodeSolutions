package tasks;

import java.util.*;

public class SortIntegersByTheNumberOf1Bits1356 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortByBits(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8})));
    }

    public static int[] sortByBits(int[] arr) {
        Map<Integer, List<Integer>> mp = new HashMap<>();

        for (int num : arr) {
            int count = countBits(num);
            List<Integer> list = mp.getOrDefault(count, new ArrayList<>());
            list.add(num);
            mp.put(count, list);
        }

        int index = 0;

        for (int i = 0; i < 32; i++) {
            if (index > arr.length)
                return arr;

            if (!mp.containsKey(i))
                continue;

            List<Integer> list = mp.get(i);
            Collections.sort(list);

            for (int num : list)
                arr[index++] = num;
        }

        return arr;
    }

    public static int countBits(int num) {
        int count = 0;

        for (int i = 0; i < 32; i++)
            count += (num >>> i) & 1;

        return count;
    }
}