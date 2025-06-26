package tasks;

public class RowWithMaximumOnes2643 {
    public static void main(String[] args) {

    }

    public static int[] rowAndMaximumOnes(int[][] mat) {
        int max = 0;
        int pos = -1;

        int i = 0;
        for (int[] nums : mat) {
            int c = 0;
            for (int num : nums) {
                if (num == 1)
                    c++;

                if (c > max) {
                    max = c;
                    pos = i;
                }
            }
            i++;
        }

        return new int[]{pos, max};
    }
}