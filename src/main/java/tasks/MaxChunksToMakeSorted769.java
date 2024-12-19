package tasks;

public class MaxChunksToMakeSorted769 {
    public static void main(String[] args) {
        System.out.println(maxChunksToSorted(new int[]{4, 3, 2, 1, 0}));
    }

    public static int maxChunksToSorted(int[] arr) {
        int count = 0, e = 0, r = 0;

        for (int i = 0; i < arr.length; i++) {
            e += i;
            r += arr[i];

            if (e == r) {
                count++;
             }
        }

        return count;
    }
}