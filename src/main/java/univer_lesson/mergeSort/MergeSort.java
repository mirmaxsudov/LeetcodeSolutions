package univer_lesson.mergeSort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = {1, 21, 413, -3, 63546325, 2354521, 13414145, 42524, 5, 45, 234, 5, 124};
        mergeSort(array);

        System.out.println("array = " + Arrays.toString(array));
    }

    public static void mergeSort(int[] array) {
        int len = array.length;
        int middle = len / 2;

        if (middle < 2)
            return;

        int[] left = new int[middle];
        int[] right = new int[len - middle];

        System.arraycopy(array, 0, left, 0, middle);

        if (len - middle >= 0) System.arraycopy(array, middle, right, 0, len - middle);

        mergeSort(left);
        mergeSort(right);

        merge(array, left, right);
    }

    public static void merge(int[] res, int[] left, int[] right) {
        int index = 0, leftIndex = 0, rightIndex = 0;
        int leftLen = left.length, rightLen = right.length;

        while (leftLen > leftIndex && rightLen > rightIndex) {
            int leftVal = left[leftIndex];
            int rightVal = right[rightIndex];

            if (leftVal <= rightVal) {
                res[index] = leftVal;
                leftIndex++;
            } else {
                res[index] = rightVal;
                rightIndex++;
            }

            index++;
        }

        for (int i = leftIndex; i < leftLen; i++)
            res[index++] = left[i];

        for (int i = rightIndex; i < rightLen; i++)
            res[index++] = right[i];
    }
}