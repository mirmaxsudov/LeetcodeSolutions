package tasks;

public class CheckIfNAndItsDoubleExist1346 {
    public static void main(String[] args) {

    }

    public static boolean checkIfExist(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j] * 2 || arr[i] * 2 == arr[j]) {
                    return true;
                }
            }
        }

        return false;
    }
}