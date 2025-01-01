package tasks;

public class MaximumScoreAfterSplittingAString1422 {
    public static void main(String[] args) {
        System.out.println(maxScore("011101") + " - " + "5");
        System.out.println(maxScore("00111") + " - " + "5");
        System.out.println(maxScore("1111") + " - " + "3");
    }

    public static int maxScore(String s) {
        int sL = 0, rL = 0, max = Integer.MIN_VALUE;

        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) == '1')
                rL++;

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0')
                sL++;
            else
                rL--;

            max = Math.max(max, sL + rL);
        }

        return max;
    }
}