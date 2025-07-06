package tasks;

import java.util.HashMap;
import java.util.Map;

public class FindingPairsWithACertainSum1865 {
    public static void main(String[] args) {

    }

    public class FindSumPairs {
        int[] nums1, nums2;
        Map<Integer, Integer> mp;

        public FindSumPairs(int[] nums1, int[] nums2) {
            this.nums1 = nums1;
            this.nums2 = nums2;
            mp = new HashMap<>();

            for (int num : nums2)
                mp.put(num, mp.getOrDefault(num, 0) + 1);
        }

        public void add(int index, int val) {
            mp.put(nums2[index], mp.get(nums2[index]) - 1);
            nums2[index] += val;
            mp.put(nums2[index], mp.getOrDefault(nums2[index], 0) + 1);
        }

        public int count(int tot) {
            int count = 0;

            for (int num : nums1)
                count += (mp.getOrDefault(tot - num, 0));

            return count;
        }
    }
}