package tasks;

public class PlusOne66 {
    public static void main(String[] args) {

    }

    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            if (digits[i] < 10)
                return digits;

            if (digits[i] == 10)
                digits[i] = 0;
        }

        int[] r = new int[digits.length + 1];
        r[0] = 1;

        return r;
    }
}
