package tasks;

import java.util.Arrays;

public class ReplaceElementsWithGreatestElementOnRightSide1299 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(replaceElements(new int[]{17, 18, 5, 4, 6, 1})));
    }

    public static int[] replaceElements(int[] arr) {
        int max = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            int tempMax = max;
            max = Math.max(arr[i], max);
            arr[i] = tempMax;
        }

        arr[arr.length - 1] = -1;
        return arr;
    }
}