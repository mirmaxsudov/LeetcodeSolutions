package tasks;

public class FindMinimumOperationsToMakeAllElementsDivisibleByThree3190 {
    public static void main(String[] args) {

    }

    public static int minimumOperations(int[] nums) {
        int cO = 0;

        for (int num : nums)
            if (num % 3 == 2 || num % 3 == 1)
                cO++;

        return cO;
    }
}