package tasks;

import java.util.Arrays;
import java.util.Random;

public class SelectionSort {
    public static void main(String[] args) {
        int[] array = new int[10];

        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10);
        }

        System.out.println(Arrays.toString(array));
        selectionSort(array);

        System.out.println(Arrays.toString(array));

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
