package tasks;

import java.util.*;

public class ThreeSum15 {
    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{
                -1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4
        }));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        Set<List<Integer>> res = new HashSet<>();

        int len = nums.length;

        for (int i = 0; i < nums.length; i++) {
            int left = i + 1, right = len - 1;

            int currentNumber = nums[i];

            while (left < right) {
                if (nums[left] + nums[right] + currentNumber == 0) {
                    res.add(Arrays.asList(currentNumber, nums[left], nums[right]));
                    left++;
                    right--;
                } else {
                    if (nums[left] + nums[right] + currentNumber < 0) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return res.stream().toList();
    }
}