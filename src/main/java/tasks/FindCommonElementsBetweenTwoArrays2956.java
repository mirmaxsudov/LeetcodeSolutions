package tasks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindCommonElementsBetweenTwoArrays2956 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findIntersectionValues(new int[]{2, 3, 2}, new int[]{1, 2})));
        System.out.println(Arrays.toString(findIntersectionValues(new int[]{4, 3, 2, 3, 1}, new int[]{2, 2, 5, 2, 3, 6})));
        System.out.println(Arrays.toString(findIntersectionValues(new int[]{3, 4, 2, 3}, new int[]{1, 5})));
    }

    public static int[] findIntersectionValues(int[] nums1, int[] nums2) {
        Map<Integer, int[]> mp = new HashMap<>();

        for (int n : nums1) {
            if (!mp.containsKey(n)) {
                mp.put(n, new int[]{1, 0});
                continue;
            }

            mp.get(n)[0]++;
        }

        for (int n : nums2) {
            if (!mp.containsKey(n)) {
                mp.put(n, new int[]{0, 1});
                continue;
            }

            mp.get(n)[1]++;
        }

        int f, s;
        f = s = 0;

        for (Map.Entry<Integer, int[]> entry : mp.entrySet()) {
            int[] arr = entry.getValue();

            if (arr[0] != 0 && arr[1] != 0) {
                f += arr[0];
                s += arr[1];
            }
        }

        return new int[]{f, s};
    }
}