package tasks;

public class FindTheHighestAltitude1732 {
    public static void main(String[] args) {
        System.out.println(largestAltitude(new int[]{-5, 1, 5, 0, -7}) + " - " + 1);
        System.out.println(largestAltitude(new int[]{-4, -3, -2, -1, 4, 3, 2}) + " - " + 0);
    }

    public static int largestAltitude(int[] gain) {
        int max = 0;
        int pre = 0;

        for (int g : gain)
            max = Math.max(pre += g, max);

        return max;
    }
}