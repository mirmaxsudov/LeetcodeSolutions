package tasks;

public class ReverseDegreeOfAString3498 {
    public static void main(String[] args) {
    }

    public static int reverseDegree(String s) {
        int sum = 0;

        for (int i = 0; i < s.length(); i++)
            sum += ((123 - s.charAt(i)) * (i + 1));

        return sum;
    }
}