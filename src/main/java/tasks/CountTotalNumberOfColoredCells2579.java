package tasks;

public class CountTotalNumberOfColoredCells2579 {
    public static void main(String[] args) {
        System.out.println(coloredCells(1));
        System.out.println(coloredCells(2));
        System.out.println(coloredCells(3));
        System.out.println(coloredCells(4));
    }

    public static long coloredCellsVer2(int n) {
        return (long) n * (long) n + ((long) n - 1) * ((long) n - 1);
    }

    public static long coloredCells(int n) {
        if (n == 1)
            return 1;

        long res = 1;
        long inc = 0;

        while (n > 1) {
            inc += 4;
            res += inc;
            n--;
        }

        return res;
    }
}