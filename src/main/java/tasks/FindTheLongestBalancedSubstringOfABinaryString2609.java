package tasks;

public class FindTheLongestBalancedSubstringOfABinaryString2609 {
    public static void main(String[] args) {
        System.out.println(findTheLongestBalancedSubstring("01000111"));
        System.out.println(findTheLongestBalancedSubstring("00111"));
    }

    public static int findTheLongestBalancedSubstring(String s) {
        int max = 0, zeros = 0, ones = 0;
        boolean isFindZero = false;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                if (!isFindZero) {
                    ones++;
                } else {
                    max = Math.max(max, Math.min(ones, zeros));
                    ones = 1;
                    zeros = 0;
                    isFindZero = false;
                }
            } else {
                zeros++;
                isFindZero = true;
            }
        }

        if (isFindZero) {
            max = Math.max(max, Math.min(ones, zeros));
        }

        return max * 2;
    }
}