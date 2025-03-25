package dataStructres;

public class HomeWork4 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 4, 4, 3, 2, 1};
        System.out.println(task(array));
    }

    public static boolean task(int[] array) {
        boolean isIncrease = true;

        for (int i = 1; i < array.length; i++) {
            if (isIncrease) {
                if (i == 1 && array[i - 1] > array[i])
                    return false;

                if (array[i - 1] > array[i]) {
                    isIncrease = false;
                    continue;
                }

                if (array[i - 1] >= array[i])
                    return false;
            } else {
                if (array[i - 1] <= array[i])
                    return false;
            }
        }

        return true;
    }
}