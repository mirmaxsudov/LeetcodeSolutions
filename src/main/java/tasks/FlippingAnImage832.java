package tasks;

public class FlippingAnImage832 {
    public static void main(String[] args) {

    }

    public static int[][] flipAndInvertImage(int[][] image) {
        for (int[] arr : image) {
            int len = arr.length;
            if (len % 2 == 0) {
                for (int i = 0; i < len / 2; i++) {
                    int t = arr[i];
                    arr[i] = arr[len - i - 1] == 0 ? 1 : 0;
                    arr[len - 1 - i] = (t == 0 ? 1 : 0);
                }
            } else {
                for (int i = 0; i <= len / 2; i++) {
                    int t = arr[i];
                    arr[i] = arr[len - i - 1] == 0 ? 1 : 0;
                    arr[len - 1 - i] = (t == 0 ? 1 : 0);
                }
            }
        }

        return image;
    }
}