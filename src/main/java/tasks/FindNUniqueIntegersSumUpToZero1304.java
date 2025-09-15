package tasks;

import java.util.Arrays;

public class FindNUniqueIntegersSumUpToZero1304 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sumZero(4)));
        System.out.println(Arrays.toString(sumZero(5)));
        System.out.println(Arrays.toString(sumZero(2)));
        System.out.println(Arrays.toString(sumZero(3)));
        System.out.println(Arrays.toString(sumZero(1)));
        System.out.println(Arrays.toString(sumZero(10)));
    }

    public static int[] sumZero(int n) {
        int[] res = new int[n];

        if (n == 1)
            return res;

        int val = n / 2;
        for (int i = 0; i < n / 2; i++) {
            res[i] = val * -1;
            res[n - i - 1] = val--;
        }

        if ((n & 1) == 1)
            res[n / 2] = 0;

        return res;
    }
}