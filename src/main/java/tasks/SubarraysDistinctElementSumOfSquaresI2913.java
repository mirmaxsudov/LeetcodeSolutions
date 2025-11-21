package tasks;

import java.util.*;

public class SubarraysDistinctElementSumOfSquaresI2913 {
    public static void main(String[] args) {
        System.out.println(sumCounts(List.of(1, 2, 1)));
    }

    public static int sumCounts(List<Integer> nums) {
        int res = 0;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i; j < nums.size(); j++) {
                Set<Integer> st = new HashSet<>();
                int sum = 0;

                for (int k = i; k <= j; k++) {
                    System.out.println(nums.get(k) + " ");
                    if (st.add(nums.get(k)))
                        sum++;
                }

                res += (sum * sum);
                System.out.println("sum = " + sum);
            }
        }

        return res;
    }
}
