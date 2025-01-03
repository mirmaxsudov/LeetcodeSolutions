package tasks.yandex;

import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) {
        long s = System.currentTimeMillis();
        System.out.println("Start" + s);
        System.out.println(solution(
                5, 2,
                new int[]{5, 4, 3, 2, 1}
        ));
        long e = System.currentTimeMillis();
        System.out.println("End" + e);

        System.out.println(e - s);
        System.out.println();
        System.out.println(solution(
                6, 3,
                new int[]{3, 6, 5, 4, 2, 1}
        ));
        System.out.println(
                solution(
                        7, 4,
                        new int[]{5, 7, 2, 4, 3, 1, 6}
                )
        );
    }

    private static int solution(int n, int target, int[] array) {
//        5 2 -> 2
//        5 4 3 2 1

//        6 3  -> 1
//        3 6 5 4 2 1

//        7 4 -> 4
//        5 7 2 4 3 1 6

        int count = 0;

        for (int i = 0; i < n; i++) {
            int l = n - i;

            for (int j = 0; j < l; j++) {
                if ((Math.abs(j - l) & 1) == 0)
                    continue;

                int[] part = Arrays.copyOfRange(array, j, l);

                if (isMedianEqualToTarget(part, target)) {
                    count++;
                }
            }
        }

        return count;
    }

    public static boolean isMedianEqualToTarget(int[] arr, int target) {
        int n = arr.length;
        int median = quickSelect(arr, 0, n - 1, n / 2);
        return median == target;
    }

    private static int quickSelect(int[] nums, int low, int high, int k) {
        if (low == high)
            return nums[low];

        int pivotIndex = partition(nums, low, high);

        if (k == pivotIndex)
            return nums[k];
        else if (k < pivotIndex)
            return quickSelect(nums, low, pivotIndex - 1, k);
        else
            return quickSelect(nums, pivotIndex + 1, high, k);

    }

    private static int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int i = low;
        for (int j = low; j < high; j++) {
            if (nums[j] <= pivot) {
                swap(nums, i, j);
                i++;
            }
        }

        swap(nums, i, high);
        return i;
    }

    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}