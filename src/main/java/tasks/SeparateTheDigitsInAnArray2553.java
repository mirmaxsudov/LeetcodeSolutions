package tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SeparateTheDigitsInAnArray2553 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(separateDigits(new int[]{13, 25, 83, 77})));
    }

    public static int[] separateDigits(int[] nums) {
        int nLen = 0;
        List<Integer> numsContainer = new ArrayList<>();

        int[] helper = new int[6];
        for (int num : nums) {
            int index = 0;

            int substr = 1;

            // 1314

            while (num > substr) {
                helper[index++] = num % (substr * 10) / substr;
                substr *= 10;
                nLen++;
            }


            for (int i = index - 1; i >= 0; i--)
                numsContainer.add(helper[i]);
        }

        int[] res = new int[nLen];

        nLen = 0;

        for (int num : numsContainer) {
            res[nLen++] = num;
        }

        return res;
    }
}