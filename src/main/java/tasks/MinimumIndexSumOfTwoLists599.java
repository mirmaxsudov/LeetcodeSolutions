package tasks;

import java.util.*;

public class MinimumIndexSumOfTwoLists599 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findRestaurant2(
                new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"},
                new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"})));
    }

    public static String[] findRestaurant2(String[] list1, String[] list2) {
        Map<String, Integer> mp = new HashMap<>();

        for (int i = 0; i < list1.length; i++)
            mp.put(list1[i], i);

        Map<String, Integer> mixed = new HashMap<>();

        for (int i = 0; i < list2.length; i++) {
            if (mp.containsKey(list2[i])) {
                mixed.put(list2[i], i + mp.get(list2[i]));
            }
        }

        if (mixed.isEmpty())
            return new String[0];

        int min = Integer.MAX_VALUE;

        for (Map.Entry<String, Integer> entry : mixed.entrySet())
            min = Math.min(min, entry.getValue());

        int count = 0;

        for (Map.Entry<String, Integer> entry : mixed.entrySet()) {
            if (entry.getValue() == min) {
                count++;
            }
        }

        String[] result = new String[count];

        int index = 0;

        for (Map.Entry<String, Integer> entry : mixed.entrySet()) {
            if (entry.getValue() == min) {
                result[index++] = entry.getKey();
            }
        }

        return result;
    }

    public static String[] findRestaurant(String[] list1, String[] list2) {
        List<Integer> indexes = new ArrayList<>();
        List<String> names = new ArrayList<>();

        int minIndex = Integer.MAX_VALUE;

        for (int i = 0; i < list1.length; i++) {
            for (int j = 0; j < list2.length; j++) {
                if (list1[i].equals(list2[j])) {
                    indexes.add(i + j);
                    names.add(list1[i]);

                    minIndex = Math.min(minIndex, i + j);
                }
            }
        }

        List<String> result = new ArrayList<>();

        for (int i = 0; i < indexes.size(); i++) {
            if (indexes.get(i) == minIndex) {
                result.add(names.get(i));
            }
        }

        return result.toArray(new String[0]);
    }
}