package tasks;


public class BoatsToSavePeople881 {
    public static void main(String[] args) {
        System.out.println(numRescueBoats(
                new int[]{1, 2}, 3
        ));
        System.out.println(numRescueBoats(
                new int[]{3, 2, 2, 1}, 3
        ));
        System.out.println(numRescueBoats(
                new int[]{3, 5, 3, 4}, 5
        ));
    }

    public static int numRescueBoats(int[] people, int limit) {
        int countBoats = 0;
        int peopleCount = 0;
        quickSort(people);

        int totalW = 0;
        for (int i = people.length - 1; i >= 0; i--) {
            totalW += people[i];
            peopleCount++;

            if (peopleCount == 2) {
                if (totalW == limit) {
                    totalW = 0;
                    countBoats++;
                } else if (totalW > limit) {
                    i++;
                    totalW = 0;
                }
            }
        }

        return countBoats;
    }

    public static void quickSort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int length = array.length;
        quickSort(array, 0, length - 1);
    }

    private static void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = array[(left + right) / 2];
        int index = partition(array, left, right, pivot);

        quickSort(array, left, index - 1);
        quickSort(array, index, right);
    }

    private static int partition(int[] array, int left, int right, int pivot) {
        while (left <= right) {
            while (array[left] < pivot)
                left++;

            while (array[right] > pivot)
                right--;

            if (left <= right) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                left++;
                right--;
            }
        }
        return left;
    }
}
