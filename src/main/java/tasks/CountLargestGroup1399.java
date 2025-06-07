package tasks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountLargestGroup1399 {
    public static void main(String[] args) {

    }

    public static int countLargestGroup(int n) {
        Map<Integer, List<Integer>> mp = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            int count = getCountN(i);
            mp.computeIfAbsent(count, k -> new ArrayList<>()).add(count);
        }

        int max = Integer.MIN_VALUE;
        int count = 0;

        for (Map.Entry<Integer, List<Integer>> entry : mp.entrySet()) {
            int size = entry.getValue().size();
            if (size == max)
                count++;
            else {
                if (size > max) {
                    max = size;
                    count = 1;
                }
            }
        }

        return count;
    }

    private static int getCountN(int num) {
        int s = 0;

        while (num != 0) {
            s += num % 10;
            num /= 10;
        }

        return s;
    }
}
