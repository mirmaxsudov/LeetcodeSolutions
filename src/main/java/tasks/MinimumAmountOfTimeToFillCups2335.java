package tasks;

public class MinimumAmountOfTimeToFillCups2335 {
    public static void main(String[] args) {
        System.out.println(fillCups(new int[]{1, 4, 2}));
        System.out.println(fillCups(new int[]{5, 4, 4}));
    }

    public static int fillCups(int[] amount) {
        int s = 0, m = 0;

        for (int num : amount) {
            s += num;
            m = Math.max(num, m);
        }

        return Math.max(m, (s + 1) / 2);
    }
}