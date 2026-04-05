package tasks;

import java.util.*;

public class TopKFrequentElements {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent(new int[]{1, 2, 2, 3, 3, 3}, 2))); // [2, 3]
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();

        for (int num : nums)
            mp.put(num, mp.getOrDefault(num, 0) + 1);

        ArrayList<Integer>[] b = new ArrayList[nums.length + 1];

        for (int key : mp.keySet()) {
            int fr = mp.get(key);

            if (b[fr] == null || b[fr].isEmpty())
                b[fr] = new ArrayList<>();

            b[fr].add(key);
        }

        int[] rs = new int[k];
        int index = 0;

        for (int i = b.length - 1; i >= 0; i--) {
            List<Integer> list = b[i];

            if (list == null || list.isEmpty())
                continue;

            for (int num : list) {
                if (k == 0)
                    return rs;
                rs[index++] = num;
                k--;
            }
        }

        return rs;
    }
}
