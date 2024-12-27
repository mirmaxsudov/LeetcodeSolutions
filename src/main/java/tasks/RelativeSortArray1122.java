package tasks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class RelativeSortArray1122 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(relativeSortArray(new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, new int[]{2, 1, 4, 3, 9, 6})));
    }

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> mp = new HashMap<>();

        for (int num : arr1)
            mp.put(num, mp.getOrDefault(num, 0) + 1);

        int[] res = new int[arr1.length];
        int i = 0;

        for (int num : arr2) {
            int count = mp.getOrDefault(num, -1);

            if (count == -1)
                continue;

            for (int j = 0; j < count; j++)
                res[i++] = num;

            mp.remove(num);
        }

        Set<Map.Entry<Integer, Integer>> entries = mp.entrySet();

        entries.stream().sorted().forEach(

        );

        for (Map.Entry<Integer, Integer> en :) {


            for (int num = 0; num < en.getValue(); num++) {
                res[i++] = en.getKey();
            }
        }

        return res;
    }
}