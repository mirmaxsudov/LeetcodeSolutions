package univerLesson.DS.slidingWindow;

public class Main {
    public static void main(String[] args) {
        System.out.println(task(new int[]{4, 8, 3, 0, 5, 6, 9, 1}, 4));
    }

    public static int task(int[] arr, int k) {
        int max;
        int sum = 0;

        for (int i = 0; i < k; i++)
            sum += arr[i];

        max = sum;

        for (int i = k; i < arr.length; i++) {
            sum += arr[i];
            sum -= arr[i - k];

            max = Math.max(sum, max);
        }

        return max;
    }
}