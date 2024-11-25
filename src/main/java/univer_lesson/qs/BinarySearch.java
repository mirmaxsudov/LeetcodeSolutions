package univer_lesson.qs;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(binarySearchIterativeWay(array, 1));
        System.out.println(binarySearchIterativeWay(array, 2));
        System.out.println(binarySearchIterativeWay(array, 3));
        System.out.println(binarySearchIterativeWay(array, 4));
        System.out.println(binarySearchIterativeWay(array, 5));
        System.out.println(binarySearchIterativeWay(array, 6));
        System.out.println(binarySearchIterativeWay(array, 7));
        System.out.println(binarySearchIterativeWay(array, 8));
        System.out.println(binarySearchIterativeWay(array, 9));
        System.out.println(binarySearchIterativeWay(array, 10));
        System.out.println(binarySearchIterativeWay(array, 101));
    }

    private static int binarySearchIterativeWay(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int middle = (left + right) / 2;

            if (array[middle] == target)
                return middle;

            if (array[middle] > target)
                right = middle - 1;
            else
                left = middle + 1;
        }

        return -1;
    }

    private static int binarySearchRec(int[] array, int target) {
        return binarySearchHelper(array, 0, array.length - 1, target);
    }

    private static int binarySearchHelper(int[] array, int left, int right, int target) {
        if (left > right)
            return -1;

        int middle = (left + right) >> 1;

        if (array[middle] == target)
            return middle;

        if (array[middle] > target)
            return binarySearchHelper(array, left, middle, target);
        else {
            return binarySearchHelper(array, middle + 1, right, target);
        }
    }
}