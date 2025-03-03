package tasks;

import java.util.Arrays;

public class RearrangeArrayElementsBySign2149 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(rearrangeArrayVer2(new int[]{3, 1, -2, -5, 2, -4})));
    }

    public static int[] rearrangeArrayVer2(int[] nums) {
        int[] res = new int[nums.length];
        int pIndex = 0;
        int nIndex = 1;

        for (int num : nums) {
            if (num >= 0) {
                res[pIndex] = num;
                pIndex += 2;
            } else {
                res[nIndex] = num;
                nIndex += 2;
            }
        }

        return res;
    }

    public static int[] rearrangeArray(int[] nums) {
        int[] negatives = new int[nums.length / 2];
        int[] positives = new int[nums.length / 2];

        int nIndex = 0;
        int pIndex = 0;

        for (int num : nums) {
            if (num >= 0)
                positives[pIndex++] = num;
            else
                negatives[nIndex++] = num;
        }

        nIndex = pIndex = 0;

        for (int i = 0; i < nums.length / 2; i += 2) {
            nums[i] = positives[pIndex++];
            nums[i + 1] = negatives[nIndex++];
        }

        return nums;
    }
}