package tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumPairRemovalToSortArrayI3507 {
    public static void main(String[] args) {
        System.out.println(minimumPairRemoval(new int[]{5, 2, 3, 1}));
    }

    public static int minimumPairRemoval(int[] nums) {
        int r = 0;
        List<Integer> list = new ArrayList<>();

        for (int num : nums)
            list.add(num);

        while (true) {
            int minNum = Integer.MAX_VALUE;
            int i1 = -1, i2 = -1;

            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i) <= list.get(i + 1))
                    continue;
                int secondMin = list.get(i) + list.get(i + 1);

                if (minNum == secondMin)
                    break;

                if (minNum > secondMin) {
                    i1 = i;
                    i2 = i + 1;
                    minNum = secondMin;
                }
            }

            if (i1 == -1 || i2 == -1)
                return r + 1;
            else {
                list.remove(i2);
                list.remove(i1);
            }
            r++;
        }
    }
}