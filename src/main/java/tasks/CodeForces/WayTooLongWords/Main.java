package tasks.CodeForces.WayTooLongWords;

import java.util.Scanner;

public class Main {
    private final static Scanner IN_STR = new Scanner(System.in);

    public static void main(String[] args) {
        int c = Integer.parseInt(IN_STR.nextLine());

        for (int i = 0; i < c; i++) {
            String str = IN_STR.nextLine();
            if (str.length() <= 10)
                System.out.println(str);
            else
                System.out.println(str.charAt(0) + "" + (str.length() - 2) + str.charAt(str.length() - 1));
        }
    }
}