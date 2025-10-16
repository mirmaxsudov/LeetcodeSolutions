package tasks;

public class AlternatingDigitSum2544 {
    public static void main(String[] args) {

    }

    public static int alternateDigitSum(int n) {
        int sum = 0;

        String val = String.valueOf(n);
        boolean isPositive = true;

        for (int i = 0; i < val.length(); i++) {
            sum += (isPositive ? val.charAt(i) - '0' : -val.charAt(i) - '0');
            isPositive = !isPositive;
        }

        return sum;
    }
}