package tasks;

import java.util.Arrays;

public class SortEvenAndOddIndicesIndependently2164 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortEvenOdd(new int[]{4, 1, 2, 3})));
        System.out.println(Arrays.toString(sortEvenOdd(new int[]{5, 39, 33, 5, 12, 27, 20, 45, 14, 25, 32, 33, 30, 30, 9, 14, 44, 15, 21})));
    }

    public static int[] sortEvenOdd(int[] nums) {
        int half = nums.length / 2;
        int[] even = new int[(nums.length & 1) == 1 ? half + 1 : half];
        int[] odd = new int[half];

        int index = 0;

        for (int i = 0; i < even.length; i++) {
            even[i] = nums[index];
            index += 2;
        }

        index = 1;
        for (int i = 0; i < odd.length; i++) {
            odd[i] = nums[index];
            index += 2;
        }

        Arrays.sort(even);
        Arrays.sort(odd);

        System.out.println(Arrays.toString(even));
        System.out.println(Arrays.toString(odd));

        int i = 0;
        for (int num : even) {
            nums[i] = num;
            i += 2;
        }

        i = 1;
        for (int j = odd.length - 1; j >= 0; j--) {
            nums[i] = odd[j];
            i += 2;
        }

        return nums;
    }
}