package tasks;

import java.util.Arrays;

public class TransformedArray3379 {
    public static void main(String[] args) {
        System.out.println((-1 % 3 + 3) % 3);
        System.out.println(Arrays.toString(constructTransformedArray(new int[]{3, -1, 1, 1})));
        System.out.println(Arrays.toString(constructTransformedArray(new int[]{-1, 4, -1})));
    }

    public static int[] constructTransformedArray(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];

//         len = 3
//        0 + -1 + 3

        for (int i = 0; i < len; i++)
            res[i] = nums[(i + nums[i] % len + len) % len];

        return res;
    }
}