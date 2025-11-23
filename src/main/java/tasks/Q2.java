package tasks;

import java.util.Arrays;

public class Q2 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(shuffle(new int[]{2, 5, 1, 3, 4, 7}, 3)));
        System.out.println(Arrays.toString(shuffle(new int[]{1, 2, 3, 4, 4, 3, 2, 1}, 4)));
    }

    public static int[] shuffle(int[] nums, int n) {
        int len = nums.length / 2;
        int mind = -1;
        int i1 = 2, i2 = 3;

        for (int i = 0; i < len; i++) {
            if (mind == -1) {
                mind = nums[1];
                nums[1] = nums[n++];
                continue;
            }

            int newMind = nums[i1];
            nums[i1] = mind;
            mind = newMind;
            nums[i2] = nums[n++];
        }

        return nums;
    }
}

/*
x=1, y=3
x = x + y; 4
y = x + y;
 */
