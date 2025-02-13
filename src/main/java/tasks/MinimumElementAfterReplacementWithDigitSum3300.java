package tasks;

public class MinimumElementAfterReplacementWithDigitSum3300 {
    public static void main(String[] args) {
        System.out.println(minElement(new int[]{999, 19, 199}));
        System.out.println(minElement(new int[]{1, 2, 3, 4}));
        System.out.println(minElement(new int[]{10, 12, 13, 14}));
    }

    public static int minElement(int[] nums) {
        int r = Integer.MAX_VALUE;

        for (int num : nums) {
            int h = 0;
            while (num != 0) {
                h += num % 10;
                num /= 10;
            }

            r = Math.min(r, h);
        }

        return r;
    }
}