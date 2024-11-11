package univer_lesson.chainResponsibility;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ATMDispenseChain atmDispenseChain = new ATMDispenseChain();
        while (true) {
            int amount = 0;
            System.out.println("Enter amount to dispense");
            Scanner input = new Scanner(System.in);
            amount = input.nextInt();

            if (amount % 10 != 0) {
                System.out.println("Amount should be in multiple of 10s.");
                return;
            }

            atmDispenseChain.c1.dispense(new Currency(amount));
        }
    }
}