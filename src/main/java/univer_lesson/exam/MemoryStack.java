package univer_lesson.exam;

public class MemoryStack {
    public static void main(String[] args) {
        int a = 10; // Local variable in main
        System.out.println("Calling the function...");
        int result = calculateSquare(a); // Function call
        System.out.println("Result: " + result);
        System.out.println("Back in main!");
    }

    public static int calculateSquare(int number) {
        System.out.println("Inside calculateSquare...");
        int square = number * number; // Local variable in calculateSquare
        System.out.println("Square of " + number + " is " + square);
        return square; // Return result to the calling function
    }
}