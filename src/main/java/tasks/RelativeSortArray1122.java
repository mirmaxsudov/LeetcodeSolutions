package tasks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RelativeSortArray1122 {
    public static void main(String[] args) {
    }

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> mp = new HashMap<>();

        for (int num : arr1)
            mp.put(num, mp.getOrDefault(num, 0) + 1);

        int[] r = new int[arr1.length];
        int i = 0;

        for (int num : arr2) {
            int c = mp.getOrDefault(num, 0);

            while (c-- > 0) {
                r[i++] = num;
            }

            mp.remove(num);
        }

        int[] end = new int[mp.size()];
        int ii = 0;

        for (Map.Entry<Integer, Integer> e : mp.entrySet())
            end[ii++] = e.getKey();

        Arrays.sort(end);

        for (int num : end) {
            int c = mp.get(num);

            while (c-- > 0) {
                r[i++] = num;
            }
        }

        return r;
    }
}