package tasks;

import java.util.Collections;
import java.util.List;

public class CountPairsWhoseSumIsLessThanTarget2824 {
    public static void main(String[] args) {
    }

    public static int countPairs(List<Integer> nums, int target) {
        int c = 0;
        Collections.sort(nums);

        int l = 0;
        int r = nums.size() - 1;

        while (l < r) {
            if (nums.get(l) + nums.get(r) < target) {
                c += (r - l);
                l++;
            } else {
                r--;
            }
        }

        return c;
    }
}