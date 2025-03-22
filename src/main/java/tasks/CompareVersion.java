package tasks;

import java.math.BigInteger;

public class CompareVersion {
    public static void main(String[] args) {
        System.out.println(compareVersion("1.2", "1.10"));
    }

    public static String multiply(String num1, String num2) {
        return new BigInteger(num1).multiply(new BigInteger(num2)).toString();
    }

    public static int compareVersion(String version1, String version2) {
        String[] values1 = version1.split("\\.");
        String[] values2 = version2.split("\\.");

        int n = Math.max(values1.length, values2.length);

        for (int i = 0; i < n; i++) {
            int v1 = i < values1.length ? Integer.parseInt(values1[i]) : 0;
            int v2 = i < values2.length ? Integer.parseInt(values2[i]) : 0;

            if (v1 > v2) return 1;
            if (v1 < v2) return -1;
        }

        return 0;
    }
}
