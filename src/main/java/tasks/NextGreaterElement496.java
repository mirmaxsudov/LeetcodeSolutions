package tasks;

import java.util.Arrays;

public class NextGreaterElement496 {
    public static void main(String[] args) {

    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            int index = findIndex(nums1[i], nums2);

            if (index == -1) {
                res[i] = -1;
                continue;
            }

            boolean isFind = false;

            for (int j = index + 1; j < nums2.length; j++) {
                if (nums2[j] > nums1[i]) {
                    res[i] = nums2[j];
                    isFind = true;
                    break;
                }
            }

            if (!isFind)
                res[i] = -1;
        }

        return res;
    }

    public int findIndex(int num, int[] nums2) {
        for (int i = 0; i < nums2.length; i++)
            if (nums2[i] == num)
                return i;

        return -1;
    }
}