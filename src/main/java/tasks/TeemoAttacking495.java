package tasks;

public class TeemoAttacking495 {
    public static void main(String[] args) {
        System.out.println(findPoisonedDuration(new int[]{1, 4}, 2));
    }

    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        int sum = 0;

        for (int i = 0; i < timeSeries.length - 1; i++)
            sum += Math.min(timeSeries[i + 1] - timeSeries[i], duration);

        sum += duration;

        return sum;
    }
}