package univer_lesson.rec;

public class Main {
    public static void main(String[] args) {

    }

    private static int fact(int n) {
        if (n == 1)
            return 1;

        return n * fact(n - 1);
    }
}
