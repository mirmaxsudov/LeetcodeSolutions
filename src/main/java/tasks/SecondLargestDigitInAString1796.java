package tasks;

public class SecondLargestDigitInAString1796 {
    public static void main(String[] args) {
        System.out.println(secondHighest("dfa12321afd"));
        System.out.println(secondHighest("sjhtz8344"));
    }

    public static int secondHighest(String s) {
        int max = -1, secondMax = -1;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                int num = c - '0';
                if (num > max) {
                    secondMax = max;
                    max = num;
                } else {
                    if (num != max)
                        secondMax = Math.max(num, secondMax);
                }
            }
        }

        return secondMax;
    }
}