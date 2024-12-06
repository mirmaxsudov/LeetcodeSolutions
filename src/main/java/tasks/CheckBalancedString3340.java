package tasks;

public class CheckBalancedString3340 {
    public static void main(String[] args) {
        System.out.println(isBalanced("24123"));
    }

    public static boolean isBalanced(String num) {
        int sum = 0;

        for (int i = 0; i < num.length(); i++) {
            if ((i & 1) == 0)
                sum += (num.charAt(i) - '0');
            else
                sum -= (num.charAt(i) - '0');
        }

        return sum == 0;
    }
}