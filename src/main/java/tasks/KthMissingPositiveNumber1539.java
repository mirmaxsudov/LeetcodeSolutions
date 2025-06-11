package tasks;

public class KthMissingPositiveNumber1539 {
    public static void main(String[] args) {
        System.out.println(findKthPositive(new int[]{2, 3, 4, 7, 11}, 5));
    }

    public static int findKthPositive(int[] arr, int k) {
        for (int num : arr) {
            if (num <= k) k++;
            else break;
        }
        return k;
    }
}
//        int howMany = 0;
//
//        int left = 0;
//        int right = arr.length - 1;
//
//        while (left < right) {
//            int midIndex = (left + right) >> 1;
//            int midVal = arr[midIndex];
//
//
//        }
//
//        return -1;
