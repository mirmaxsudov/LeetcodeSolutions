package tasks;

public class ArrangingCoins441 {
    public static void main(String[] args) {
        System.out.println(arrangeCoins(5));
        System.out.println(arrangeCoins(8));
        System.out.println(arrangeCoins(3));
    }

    public static int arrangeCoins(int n) {
        if (n <= 1)
            return n;

        int rowCount = 0;
        int row = 1;

        while (row <= n) {
            rowCount++;
            n -= row;
            row++;
        }

        return rowCount;
    }
}