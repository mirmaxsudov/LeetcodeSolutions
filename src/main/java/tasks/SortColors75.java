package tasks;

import java.util.Arrays;

public class SortColors75 {
    public static void main(String[] args) {
        int[] arr = {2, 0, 2, 1, 1, 0};
        sortColors(arr);
        System.out.println("arr = " + Arrays.toString(arr));
        int[] arr2 = {2, 0, 1};
        sortColors(arr2);
        System.out.println("arr2 = " + Arrays.toString(arr2));
    }

    public static void sortColors(int[] nums) {
        int[] c = new int[3];

        for (int num : nums)
            c[num]++;

        int index = 0;

        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < c[j]; i++) {
                nums[index++] = j;
            }
        }
    }
}