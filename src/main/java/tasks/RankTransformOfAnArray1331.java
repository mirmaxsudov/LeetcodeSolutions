package tasks;

import java.util.*;

public class RankTransformOfAnArray1331 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(arrayRankTransform(new int[]{40, 10, 20, 30})));
    }

    public static int[] arrayRankTransform(int[] arr) {
        int[] clone = Arrays.copyOf(arr, arr.length);

        Arrays.sort(clone);

        Map<Integer, Integer> mp = new HashMap<>();
        int index = 1;

        for (int num : clone)
            if (!mp.containsKey(num))
                mp.put(num, index++);

        for (int i = 0; i < arr.length; i++)
            arr[i] = mp.get(arr[i]);

        return arr;
    }
}
