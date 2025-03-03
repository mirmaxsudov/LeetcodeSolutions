package tasks;

import java.util.Arrays;

public class PartitionArrayAccordingToGivenPivot2161 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(pivotArray(new int[]{9, 12, 5, 10, 14, 3, 10}, 10)));
    }

    public static int[] pivotArray(int[] nums, int pivot) {
        int len = nums.length;

        int l = 0;
        int r = len - 1;
        int[] res = new int[len];

        int c = 0;

        for (int num : nums) {
            if (num == pivot)
                c++;
            else if (num < pivot) {
                res[l++] = num;
            } else {
                res[r--] = num;
            }
        }

        for (int j = 0; j < c; j++)
            res[l++] = pivot;

        int lHelper = 0;

        for (int i = l; i < len - ((len - l) / 2); i++) {
            int temp = res[i];
            res[i] = res[len - 1 - lHelper];
            res[len - 1 - lHelper++] = temp;
        }

        return res;
    }
}