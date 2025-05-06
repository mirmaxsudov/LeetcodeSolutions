package univerLesson.DS;

import java.util.Arrays;
import java.util.Scanner;

public class AskValuesAndBubbleSort {
    private final static Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[SCANNER.nextInt()];
        for (int i = 0; i < arr.length; i++)
            arr[i] = SCANNER.nextInt();
        mergeSort(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int l, int r) {

    }

    private static int[] merge(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j])
                result[k] = arr1[i++];
            else
                result[k] = arr2[j++];
            k++;
        }

        while (i < arr1.length)
            result[k++] = arr1[i++];

        while (j < arr2.length)
            result[k++] = arr2[j++];

        return result;
    }

    private static void bubble(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}