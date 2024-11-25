package univer_lesson.qs;

public class TriangleNumber {
    public static void main(String[] args) {
        System.out.println(findTriangleNumberWithRec(1));
        System.out.println(findTriangleNumberWithRec(2));
        System.out.println(findTriangleNumberWithRec(3));
        System.out.println(findTriangleNumberWithRec(4));
        System.out.println(findTriangleNumberWithRec(5));
        System.out.println(findTriangleNumberWithRec(6));
        System.out.println(findTriangleNumberWithoutRec(1));
        System.out.println(findTriangleNumberWithoutRec(2));
        System.out.println(findTriangleNumberWithoutRec(3));
        System.out.println(findTriangleNumberWithoutRec(4));
        System.out.println(findTriangleNumberWithoutRec(5));
        System.out.println(findTriangleNumberWithoutRec(6));
    }

    public static int findTriangleNumberWithRec(int row) {
        if (row == 1)
            return 1;

        return row + findTriangleNumberWithRec(row - 1);
    }

    public static int findTriangleNumberWithoutRec(int row) {
        int sum = 0;

        while (row != 0)
            sum += row--;

        return sum;
    }
}