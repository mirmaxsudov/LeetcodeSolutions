package tasks;

import java.util.HashMap;
import java.util.Map;

public class Q1 {

    static class Solution {
        public int maxSumDistinctTriplet(int[] x, int[] y) {
            Map<Integer, Integer> best = new HashMap<>();
            for (int i = 0; i < x.length; i++)
                best.merge(x[i], y[i], Math::max);

            if (best.size() < 3) return -1;

            int max1 = 0, max2 = 0, max3 = 0;
            for (int v : best.values()) {
                if (v > max1) {
                    max3 = max2;
                    max2 = max1;
                    max1 = v;
                } else if (v > max2) {
                    max3 = max2;
                    max2 = v;
                } else if (v > max3) {
                    max3 = v;
                }
            }

            return max1 + max2 + max3;
        }
    }
}