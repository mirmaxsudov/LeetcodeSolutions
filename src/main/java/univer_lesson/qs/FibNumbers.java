package univer_lesson.qs;

public class FibNumbers {
    public static void main(String[] args) {
        System.out.println(findFicWithRec(0));
        System.out.println(findFicWithRec(1));
        System.out.println(findFicWithRec(2));
        System.out.println(findFicWithRec(3));
        System.out.println(findFicWithRec(4));
        System.out.println(findFicWithRec(5));
        System.out.println(findFicWithRec(6));
        System.out.println(findFicWithoutRec(0));
        System.out.println(findFicWithoutRec(1));
        System.out.println(findFicWithoutRec(2));
        System.out.println(findFicWithoutRec(3));
        System.out.println(findFicWithoutRec(4));
        System.out.println(findFicWithoutRec(5));
        System.out.println(findFicWithoutRec(6));
    }

    public static int findFicWithRec(int n) {
        if (n == 0)
            return 0;
        if (n <= 2)
            return 1;

        return findFicWithRec(n - 1) + findFicWithRec(n - 2);
    }

    public static int findFicWithoutRec(int n) {
        if (n == 0)
            return 0;
        if (n <= 2)
            return 1;

        int first = 1, second = 1, third = first + second;

        while (n > 2) {
            third = first + second;
            first = second;
            second = third;
            n--;
        }

        return third;
    }
}