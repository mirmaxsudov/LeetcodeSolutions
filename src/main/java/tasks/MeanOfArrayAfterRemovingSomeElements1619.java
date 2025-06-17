package tasks;

import java.util.Arrays;

public class MeanOfArrayAfterRemovingSomeElements1619 {
    public static void main(String[] args) {

    }

    public static double trimMean(int[] arr) {
        Arrays.sort(arr);

        int skip = (arr.length * 5) / 100;
        double sum = 0;

        for (int i = skip; i < arr.length - skip; i++)
            sum += arr[i];

        return sum / (arr.length - skip * 2);
    }
}