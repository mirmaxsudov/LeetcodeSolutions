package tasks;

public class SumOfAllOddLengthSubArrays1588 {
    public static void main(String[] args) {

    }

    public static int sumOddLengthSubArrays(int[] arr) {
        int sum = 0;

        for (int i = 0; i < arr.length; i++)
            sum += (arr[i] * ((((i + 1) * (arr.length - i)) + 1) / 2));

        return sum;
    }
}