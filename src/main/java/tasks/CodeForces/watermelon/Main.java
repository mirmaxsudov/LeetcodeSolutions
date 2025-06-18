package tasks.CodeForces.watermelon;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int weight = in.nextInt();

        System.out.println((weight & 1) == 0 && weight > 2 ? "YES" : "NO");
    }
}
