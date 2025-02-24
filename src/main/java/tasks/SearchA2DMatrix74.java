package tasks;

public class SearchA2DMatrix74 {
    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][]{{
                1, 3, 5, 7
        }, {
                10, 11, 16, 20
        }, {
                23, 30, 34, 60
        }}, 3));
        System.out.println(searchMatrix(new int[][]{{
                1, 3, 5, 7
        }, {
                10, 11, 16, 20
        }, {
                23, 30, 34, 60
        }}, 13));

        System.out.println(searchMatrix(new int[][]{{1}}, 1));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        for (int[] arr : matrix) {
            if (arr[0] <= target && arr[arr.length - 1] >= target) {
                int l = 0;
                int r = arr.length - 1;

                while (l <= r) {
                    int mid = (l + r) / 2;

                    if (arr[mid] == target)
                        return true;

                    if (arr[mid] < target) {
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
            }
        }

        return false;
    }
}