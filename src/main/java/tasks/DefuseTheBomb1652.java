package tasks;

import java.util.Arrays;

public class DefuseTheBomb1652 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(decryptVer2(new int[]{5, 7, 1, 4}, 3)));
        System.out.println(Arrays.toString(decryptVer2(new int[]{1, 2, 3, 4}, 0)));
        System.out.println(Arrays.toString(decryptVer2(new int[]{2, 4, 9, 3}, -2)));
    }

    public static int[] decryptVer2(int[] codes, int k) {
        if (k == 0)
            return new int[codes.length];

        int[] res = new int[codes.length];

        for (int i = 0; i < codes.length; i++) {
            int l = i + 1, r = i + k;

            if (k < 0) {
                l = codes.length + i + k;
                r = codes.length + i - 1;
            }

            while (l <= r) {
                res[i] += codes[l % codes.length];
                l++;
            }
        }

        return res;
    }

    public static int[] decrypt(int[] codes, int k) {
        if (k == 0)
            return new int[codes.length];

        int sum = 0;

        for (int code : codes)
            sum += code;

        int len = codes.length;
        int[] res = new int[len];

        for (int i = 0; i < codes.length; i++) {
            int c = 0;

            if (len - 1 == k) {
                res[i] = sum - codes[i];
                continue;
            }

            int dCode = 0;

            if (k < 0) {
                for (int j = i - 1, ik = Math.abs(k); j >= 0 && ik > 0; j--, ik--, c++)
                    dCode += codes[j];

                if (c != Math.abs(k))
                    for (int j = len - 1, ik = c; j >= 0 && ik != Math.abs(k); j--, ik++)
                        dCode += codes[j];
            } else {
                for (int j = i + 1, ik = k; j < len && ik != 0 && c != k; j++, ik--, c++)
                    dCode += codes[j];

                if (c != k)
                    for (int j = 0; j < len && c != k; j++, c++)
                        dCode += codes[j];
            }

            res[i] = dCode;
        }

        return res;
    }
}