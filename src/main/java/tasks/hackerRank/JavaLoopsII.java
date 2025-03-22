package tasks.hackerRank;

import java.util.Scanner;

public class JavaLoopsII {
    private final static Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        int n = SCANNER.nextInt();

        for (int i = 0; i < n; i++) {
            int a = SCANNER.nextInt();
            int b = SCANNER.nextInt();
            int count = SCANNER.nextInt();

            long sum = a;

            for (int j = 0; j < count; j++) {
                sum += (long) ((Math.pow(2, j) * b));

                System.out.print(sum + " ");
            }
            System.out.println();
        }

        SCANNER.close();
    }
}