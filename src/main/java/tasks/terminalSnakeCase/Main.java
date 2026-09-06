package tasks.terminalSnakeCase;

public class Main {
    public static void main(String[] args) {
        System.out.print("\033[H");      // cursor to top-left
        System.out.print("\033[?25l");   // hide cursor
        System.out.print("\033[32m");    // green
        System.out.print("██");
        System.out.print("\033[0m");     // reset
    }
}
