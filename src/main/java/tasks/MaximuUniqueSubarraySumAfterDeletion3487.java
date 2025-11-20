package tasks;

import java.util.HashSet;
import java.util.Set;

public class MaximuUniqueSubarraySumAfterDeletion3487 {
    public static void main(String[] args) {

    }

    public int maxSum(int[] nums) {
        int sum = 0;

        Set<Integer> st = new HashSet<>();
        int negativeSum = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num > 0 && !st.contains(num)) {
                sum += num;
                st.add(num);
            } else if (num <= 0) {
                negativeSum = Math.max(negativeSum, num);
            }
        }

        return sum == 0 ? negativeSum : sum;
    }
}
