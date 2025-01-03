package tasks;

import java.util.Arrays;

public class FindTheMiddleIndexInArray1991 {
    public static void main(String[] args) {
        System.out.println(findMiddleIndex(new int[]{2, 3, -1, 8, 4}) + " - " + 3);
        System.out.println(findMiddleIndex(new int[]{1, -1, 4}) + " - " + 2);
        System.out.println(findMiddleIndex(new int[]{2, 5}) + " - " + -1);
    }

    public static int findMiddleIndex(int[] nums) {
        int left = 0, right = 0;
        int mid = 0;

        for (int num : nums)
            right += num;

        right -= nums[0];

        while (true) {
            if (left == right)
                return mid;

            if (mid == nums.length - 1)
                return -1;

            left += nums[mid];
            right -= nums[++mid];
        }
    }

//    public static int findMiddleIndex(int[] nums) {
//        long[] p = new long[nums.length];
//
//        p[0] = nums[0];
//
//        for (int i = 1; i < nums.length; i++)
//            p[i] += nums[i] + p[i - 1];
//
//        System.out.println("p = " + Arrays.toString(p));
//
//        if (p[nums.length - 1] - nums[0] == 0)
//            return 0;
//
//        for (int i = 1; i < nums.length; i++)
//            if (p[i] - nums[i] == p[nums.length - 1])
//                return i;
//
//        if (p[nums.length - 1] - nums[nums.length - 1] == 0)
//            return nums.length - 1;
//
//        return -1;
//    }
}