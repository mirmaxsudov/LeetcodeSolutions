package tasks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestWithYandex {
    public static void main(String[] args) {
        System.out.println(getMaxDays(List.of(new int[]{1, 3}, new int[]{2, 4}, new int[]{5, 6})));
    }

    public static List<Integer> getMaxDays(List<int[]> users) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for (int[] user : users) {
            min = Math.min(user[0], min);
            max = Math.max(user[1], max);
        }

        Map<Integer, Integer> mp = new HashMap<>();

        for (int[] user : users) {
            int s = user[0], e = user[1];

            for (int i = s; i <= e; i++)
                mp.put(i, mp.getOrDefault(i, 0) + 1);
        }

        int maxUsersCount = 0;

        List<Integer> r = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            if (maxUsersCount == entry.getValue()) {
                r.add(entry.getKey());
            } else if (entry.getValue() > maxUsersCount) {
                r.clear();
                r.add(entry.getKey());
                maxUsersCount = entry.getValue();
            }
        }

        return r;
    }
}
