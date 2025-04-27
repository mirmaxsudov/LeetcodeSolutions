package tasks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindTheDifferenceOfTwoArrays2215 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Map<Integer, Boolean> mp = new HashMap<>();

        for (int num : nums1)
            mp.put(num, true);

        List<Integer> a1 = new ArrayList<>();
        List<Integer> a2 = new ArrayList<>();

        for (int num : nums2) {
            if (!mp.containsKey(num)) {
                a2.add(num);
            } else {
                mp.remove(num);
            }
        }

        for (Map.Entry<Integer, Boolean> en : mp.entrySet())
            a1.add(en.getKey());

        return List.of(a1, a2);
    }
}