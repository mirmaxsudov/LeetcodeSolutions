package tasks.hackerRank;

import java.util.Scanner;

public class JavaDatatypes {
    private final static Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine().trim());

        for (int i = 0; i < n; i++) {
            String s = scanner.nextLine().trim();

            if (s.isEmpty()) {
                i--;
                continue;
            }

            checkAndPrint(s);
        }

        scanner.close();
    }

    private static void checkAndPrint(String s) {
        StringBuilder sb = new StringBuilder();
        int c = 0;
        try {
            Short.parseShort(s);
            sb.append("* short\n");
        } catch (NumberFormatException e) {
            c++;
        }

        try {
            Integer.parseInt(s);
            sb.append("* int\n");
        } catch (NumberFormatException e) {
            c++;
        }

        try {
            Long.parseLong(s);
            sb.append("* long");
        } catch (NumberFormatException e) {
            c++;
        }

        if (c == 3)
            System.out.println(s + " can't be fitted anywhere.");
        else {
            System.out.println(s + " can be fitted in:");
            System.out.println(sb);
        }
    }
}