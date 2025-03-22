package tasks.hackerRank;

import java.util.Scanner;

public class JavaOutputFormating {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("================================");
        for (int i = 0; i < 3; i++) {
            String word = SCANNER.next().trim();
            int num = SCANNER.nextInt();
            System.out.printf("%-15s%03d%n", word, num);
        }
        System.out.println("================================");
    }
}