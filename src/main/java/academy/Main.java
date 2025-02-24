package academy;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println((task(new int[]{1, 4, 7, 12, 15}, 19))); // [4, 15]
        System.out.println((task(new int[]{1, 3, 11, 5, 10}, 15)));
        System.out.println((task(new int[]{1, 3, 11, 5, 10}, 5)));
    }

    public static boolean task(int[] arr, int res) {
        Arrays.sort(arr);

        int l = 0;
        int r = arr.length - 1;

        while (l < r) {
            int s = arr[l] + arr[r];

            if (s == res) {
                System.out.println("[" + arr[l] + ", " + arr[r] + "]");
                return true;
            } else if (s > res) {
                r--;
            } else {
                l++;
            }
        }

        System.out.println("Natija yo'q");
        return false;
    }
}