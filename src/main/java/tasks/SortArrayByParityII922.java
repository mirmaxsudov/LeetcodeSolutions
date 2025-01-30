package tasks;

import java.util.Arrays;

public class SortArrayByParityII922 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArrayByParityII(
                new int[]{4, 2, 5, 7}
        )));
    }

    public static int[] sortArrayByParityII(int[] nums) {
        int oddIndex = 1;
        int evenIndex = 0;

        int[] res = new int[nums.length];

        for (int num : nums) {
            if ((num & 1) == 0) {
                res[evenIndex] = num;
                evenIndex += 2;
            } else {
                res[oddIndex] = num;
                oddIndex += 2;
            }
        }

        return res;
    }
}