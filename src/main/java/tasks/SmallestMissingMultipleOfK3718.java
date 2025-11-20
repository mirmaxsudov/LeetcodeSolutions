package tasks;

public class SmallestMissingMultipleOfK3718 {
    public static void main(String[] args) {

    }

    public static int missingMultiple(int[] nums, int k) {
        for (int i = 2; i < 100; i++)
            if (k % i == 0)
                return i;

        return -1;
    }
}
