package tasks;

public class BinarySearch {


    public static void main(String[] args) {
        System.out.println(binarySearchRecursive(new int[]{1, 2, 3, 4, 5, 50, 60}, 1));
        System.out.println(binarySearchRecursive(new int[]{1, 2, 3, 4, 5, 50, 60}, 2));
        System.out.println(binarySearchRecursive(new int[]{1, 2, 3, 4, 5, 50, 60}, 3));
        System.out.println(binarySearchRecursive(new int[]{1, 2, 3, 4, 5, 50, 60}, 4));
        System.out.println(binarySearchRecursive(new int[]{1, 2, 3, 4, 5, 50, 60}, 5));
        System.out.println(binarySearchRecursive(new int[]{1, 2, 3, 4, 5, 50, 60}, 50));
        System.out.println(binarySearchRecursive(new int[]{1, 2, 3, 4, 5, 50, 60}, 60));
        System.out.println(binarySearchRecursive(new int[]{1, 2, 3, 4, 5, 50, 60}, -1));
    }

    public static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (nums[middle] == target)
                return middle;

            if (nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }

        }

        return -1;
    }

    public static int binarySearchRecursive(int[] nums, int target) {
        return binarySearchRecursive(nums, target, 0, nums.length - 1);
    }

//        System.out.println(binarySearchRecursive(new int[]{1, 2, 3, 4, 5, 50, 60}, -1));
    private static int binarySearchRecursive(int[] nums, int target, int left, int right) {
        if (left > right)
            return -1;

        int middle = left + (right - left) / 2;

        if (nums[middle] == target)
            return middle;

        if (nums[middle] > target)
            return binarySearchRecursive(nums, target, left, middle - 1);

        return binarySearchRecursive(nums, target, middle + 1, right);
    }
}
