package univer_lesson;

public class FacNumber {
    public static void main(String[] args) {
        System.out.println(findFacNumberWithRec(0));
        System.out.println(findFacNumberWithRec(1));
        System.out.println(findFacNumberWithRec(2));
        System.out.println(findFacNumberWithRec(3));
        System.out.println(findFacNumberWithRec(4));
        System.out.println(findFacNumberWithRec(5));
        System.out.println(findFacNumberWithRec(6));
        System.out.println(findFacNumberWithoutRec(0));
        System.out.println(findFacNumberWithoutRec(1));
        System.out.println(findFacNumberWithoutRec(2));
        System.out.println(findFacNumberWithoutRec(3));
        System.out.println(findFacNumberWithoutRec(4));
        System.out.println(findFacNumberWithoutRec(5));
        System.out.println(findFacNumberWithoutRec(6));
    }

    public static int findFacNumberWithRec(int row) {
        if (row <= 1)
            return 1;

        return row * findFacNumberWithRec(row - 1);
    }

    public static long findFacNumberWithoutRec(int row) {
        long sum = 1;

        while (row > 0)
            sum *= row--;

        return sum;
    }
}