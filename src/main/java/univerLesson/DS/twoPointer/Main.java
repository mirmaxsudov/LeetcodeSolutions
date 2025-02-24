package univerLesson.DS.twoPointer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
//        System.out.println(toSumWithTwoPointer(new int[]{1, 2, 31, 413, 513, 13, 3, 41}, 6));
//        System.out.println(Arrays.toString(threeSum(new int[]{1, 3, 5, 7, 9, 11, 14}, 9 + 11 + 14)));
//        System.out.println(Arrays.toString(threeSumWithSet(new int[]{1, 3, 5, 7, 9, 11, 14}, 9 + 11 + 14)));
//        System.out.println(Arrays.toString(threeSumWithSet(new int[]{1, 3, 5, 7, 9, 11, 14}, 15)));
//        System.out.println(Arrays.toString(threeSumWithSetVer2(new int[]{7, 5, 9, 11, 3, 14, 1}, 15)));
        System.out.println(Arrays.toString(twoSumWithMid(new int[]{4, 2, 5, 1, 8, 3, 6, 7}, 14)));
    }

    public static int[] twoSumWithMid(int[] arr, int target) {
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            int c = arr[i];

            int l = i + 1;
            int r = arr.length - 1;

            while (l <= r) {
                int mid = (l + r) / 2;
                int s = c + arr[mid];

                if (s == target)
                    return new int[]{i, mid};
                else if (s > target) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }

        return new int[]{-1, -1};
    }

    public static int[] threeSumWithSetVer2(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            Set<Integer> st = new HashSet<>();
            st.add(arr[i]);
            for (int j = i + 1; j < arr.length; j++) {
                int a = target - arr[i] - arr[j];
                if (st.contains(a))
                    return new int[]{};
            }
        }

        return new int[]{-1, -1, -1};
    }

    public static int[] threeSumWithSet(int[] arr, int target) {
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            int l = i;
            int r = arr.length - 1;

            Set<Integer> st = new HashSet<>();
            st.add(arr[i]);

            while (l < r) {
                if (st.contains(target - arr[l] - arr[r]))
                    return new int[]{i, l, r};
                else if (target - arr[l] - arr[r] > 0)
                    l++;
                else
                    r--;
            }
        }

        return new int[]{-1, -1, -1};
    }

    public static int[] threeSum(int[] arr, int target) {
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            int l = i + 1;
            int r = arr.length - 1;

            while (l < r) {
                int s = arr[i] + arr[l] + arr[r];

                if (s == target)
                    return new int[]{i, l, r};
                else if (s > target)
                    r--;
                else
                    l++;
            }
        }

        return new int[]{-1, -1, -1};
    }

    public static boolean toSumWithTwoPointer(int[] arr, int target) {
        int l = 0, r = arr.length - 1;

        while (l < r) {
            if (arr[l] + arr[r] == target)
                return true;
            else if (arr[l] + arr[r] > target)
                r--;
            else
                l++;
        }

        return false;
    }

    public static boolean toSum(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++)
            for (int j = i + 1; j < arr.length; j++)
                if (arr[i] + arr[j] == target)
                    return true;

        return false;
    }
}