package tasks;

import java.util.*;

public class GeneralClass {
    public static void main(String[] args) {

    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums1)
            set.add(num);

        List<Integer> nums = new ArrayList<>();
        Set<Integer> without = new LinkedHashSet<>();

        for (int num : nums2)
            if (set.contains(num) && !without.contains(num)) {
                nums.add(num);
                without.add(num);
            }

        return nums.stream().mapToInt(Integer::intValue).toArray();
    }
}
