package tasks;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSumClosest16 {
    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
        System.out.println(threeSumClosest(new int[]{0, 0, 0}, 1));
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int h = -1;
        int prevDis = 0;

        for (int i = 0; i < nums.length; i++) {
            int l = i + 1;
            int r = nums.length - 1;

            while (l < r) {
                int s = nums[i] + nums[l] + nums[r];

                if (s == target)
                    return s;

                if (Math.abs(target - h) > Math.abs(target - s))
                    h = s;

                if (prevDis > Math.abs(s)) {
                    r--;
                } else {
                    l++;
                }

                prevDis = s;
            }
        }

        return h;
    }
}