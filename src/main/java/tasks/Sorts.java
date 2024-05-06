package tasks;

import java.util.Arrays;
import java.util.Random;

public class Sorts {
    public static void main(String[] args) {
        int[] array = new int[10];

        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10);
        }

        System.out.println(Arrays.toString(array));
//        selectionSort(array);
//        insertionSort(array);
//        bubbleSort(array);
        mergeSort(array);
        System.out.println(Arrays.toString(array));


    }

    private static void mergeSort(int[] array) {
        int length = array.length;

        if (length < 2) {
            return;
        }

        int middle = length >> 1;
        int[] left = new int[middle];
        int[] right = new int[length - middle];

        mergeSort(left);
        mergeSort(right);

        merge(array, left, right);
    }

    private static void merge(int[] array, int[] left, int[] right) {
        int leftSize = left.length;
        int rightSize = right.length;

        int i = 0, j = 0, k = 0;

        while (i < leftSize && j < rightSize) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
                i++;
            } else {
                array[k++] = right[j++];
                j++;
            }
            k++;
        }

        while (i < leftSize) {
            array[k++] = left[i++];
        }

        while (j < rightSize) {
            array[k++] = right[rightSize++];
        }
    }

    private static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    private static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int num = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > num) {
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = num;
        }
    }

    private static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int num = array[i];
            int minNum = num;
            int minIndex = -1;

            for (int j = i + 1; j < array.length; j++) {
                if (minNum > array[j]) {
                    minNum = array[j];
                    minIndex = j;
                }
            }

            if (minIndex == -1)
                break;

            array[minIndex] = num;
            array[i] = minNum;
        }
    }
}
