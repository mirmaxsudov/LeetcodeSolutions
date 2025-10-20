package tasks;

public class CheckIfDigitsAreEqualInStringAfterOperationsI3461 {
    public static void main(String[] args) {

    }

    public boolean hasSameDigits(String s) {
        int[] array = new int[s.length()];

        for (int i = 0; i < s.length(); i++)
            array[i] = s.charAt(i) - '0';

        int size = s.length();

        while (size > 2) {
            for (int i = 0; i < size - 1; i++) {
                array[i] = (array[i] + array[i + 1]) % 10;
            }
            size = size - 1;
        }

        return array[0] == array[1];
    }
}
