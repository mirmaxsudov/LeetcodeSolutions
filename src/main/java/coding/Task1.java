package coding;

public class Task1 {
    public static void main(String[] args) {
    }

    public static int factorial(int n) {
        if (n == 0)
            return 1;
        return n * factorial(n - 1);
    }

    public static boolean loneTeen(int a, int b) {
        if (checkTeen(a) && checkTeen(b))
            return false;

        return checkTeen(a) || checkTeen(b);
    }


    public static boolean checkTeen(int n) {
        return n >= 13 && n <= 19;
    }
}
