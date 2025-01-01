package tasks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertAnArrayIntoA2DArrayWithConditions2610 {
    public static void main(String[] args) {
        System.out.println(findMatrix2(new int[]{1, 3, 4, 1, 2, 3, 1}));
        System.out.println(findMatrix2(new int[]{1, 2, 3, 4}));
    }

    public static List<List<Integer>> findMatrix2(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();

        int[] f = new int[nums.length + 1];

        for (int num : nums) {
            if (f[num] >= list.size())
                list.add(new ArrayList<>());
            list.get(f[num]++).add(num);
        }

        return list;
    }

    public static List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();

        Map<Integer, Integer> mp = new HashMap<>();

        for (int num : nums)
            mp.put(num, mp.getOrDefault(num, 0) + 1);


        Map<Integer, Integer> indexes = new HashMap<>();

        for (int num : nums) {
            if (indexes.containsKey(num))
                continue;

            indexes.put(num, 0);
        }

        while (true) {
            boolean isUsed;
            for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
                int key = entry.getKey(), val = entry.getValue();

                if (val == 0)
                    continue;

                int index = indexes.get(key);

                if (list.size() > index) {
                    list.get(index).add(key);
                } else {
                    List<Integer> newList = new ArrayList<>();
                    newList.add(key);
                    list.add(newList);
                }

                mp.put(key, val - 1);
                indexes.put(key, index + 1);
            }

            isUsed = false;

            for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
                if (entry.getValue() != 0) {
                    isUsed = true;
                    break;
                }
            }

            if (!isUsed)
                break;
        }

        return list;
    }
}