package tasks;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> rs = new ArrayList<>();

        Arrays.sort(nums);

        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            int l = i + 1, r = nums.length - 1;

            while (l < r) {
                int s = nums[i] + nums[l] + nums[r];
                if (s == 0) {
                    r--;
                    l++;

                    if (set.contains(List.of(nums[i], nums[l], nums[r])))
                        continue;

                    rs.add(List.of(nums[i], nums[l], nums[r]));
                    set.add(List.of(nums[i], nums[l], nums[r]));
                } else if (s > 0)
                    r--;
                else
                    l++;
            }
        }

        return rs;
    }
}
