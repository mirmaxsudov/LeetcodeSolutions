package tasks;

import java.util.*;

public class MaximumNumberOfIntegersToChooseFromARangeI2554 {
    public static void main(String[] args) {
        System.out.println(maxCount(new int[]{1, 6, 5}, 5, 6));
        System.out.println(maxCount(new int[]{11}, 7, 50));
        System.out.println(maxCount(new int[]{1, 2, 3, 4, 5, 6, 7}, 8, 1));
        System.out.println(maxCount(new int[]{176, 36, 104, 125, 188, 152, 101, 47, 51, 65, 39, 174, 29, 55, 13, 138, 79, 81, 175, 178, 42, 108, 24, 80, 183, 190, 123, 20, 139, 22, 140, 62, 58, 137, 68, 148, 172, 76, 173, 189, 151, 186, 153, 57, 142, 105, 133, 114, 165, 118, 56, 59, 124, 82, 49, 94, 8, 146, 109, 14, 85, 44, 60, 181, 95, 23, 150, 97, 28, 182, 157, 46, 160, 155, 12, 67, 135, 117, 2, 25, 74, 91, 71, 98, 127, 120, 130, 107, 168, 18, 69, 110, 61, 147, 145, 38},
                3016, 240));
    }

    public static int maxCount(int[] banned, int n, int maxSum) {
        Arrays.sort(banned);

        Set<Integer> st = new HashSet<>();

        for (int j : banned) st.add(j);

        Set<Integer> fully = new HashSet<>();

        for (int i = 1; i <= n; i++)
            fully.add(i);

        fully.removeAll(st);

        List<Integer> list = new ArrayList<>(fully.stream().toList());

        if (maxSum <= n)
            list.removeIf(num -> num > maxSum);

        int sum = list.stream().reduce(0, Integer::sum);

        if (sum <= maxSum)
            return list.size();

        int right = list.size() - 1;

        while (sum > maxSum) {
            if (right == 0)
                return 0;

            sum -= list.get(right--);
        }

        return right + 1;
    }
}
