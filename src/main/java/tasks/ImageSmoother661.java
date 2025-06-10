package tasks;

public class ImageSmoother661 {
    public static void main(String[] args) {

    }

    public int[][] imageSmoother(int[][] img) {
        int rl = img.length;
        int cl = img[0].length;
        int[][] res = new int[rl][cl];

        for (int i = 0; i < img.length; i++) {
            for (int j = 0; j < img[i].length; j++) {
                int t = 0;
                int c = 0;

                for (int m = Math.max(i - 1, 0); m < Math.min(i + 2, rl); ++m) {
                    for (int n = Math.max(j - 1, 0); n < Math.min(j + 2, cl); ++n) {
                        t += img[m][n];
                        c++;
                    }
                }

                img[i][j] = t / c;
            }
        }

        return res;
    }
}