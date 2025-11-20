package tasks;

public class FindTheLeastFrequentDigit3663 {
    public static void main(String[] args) {
        System.out.println(getLeastFrequentDigit(2));
    }

    public static int getLeastFrequentDigit(int n) {
        int[] counts = new int[10];

        while (n != 0) {
            counts[n % 10]++;
            n /= 10;
        }

        int min = 0, count = counts[0];

        for (int c = 0; c <= 9; c++) {
            if (counts[c] == 0)
                continue;

            if (count == 0) {
                min = c;
                count = counts[c];
                continue;
            }

            if (count == counts[c]) {
                min = Math.min(c, min);
            } else if (count > counts[c]) {
                min = c;
                count = counts[c];
            }
        }

        return min;
    }
}
