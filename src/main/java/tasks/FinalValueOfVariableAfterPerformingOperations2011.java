package tasks;

public class FinalValueOfVariableAfterPerformingOperations2011 {
    public static void main(String[] args) {
        System.out.println(finalValueAfterOperations(new String[]{
                "--X", "X++", "X++"
        }));
    }

    public static int finalValueAfterOperations(String[] operations) {
        int sum = 0;

        for (String s : operations)
            sum += (s.charAt(1) == '+' ? 1 : -1);

        return sum;
    }
}