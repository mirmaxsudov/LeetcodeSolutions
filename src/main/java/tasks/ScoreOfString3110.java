package tasks;

public class ScoreOfString3110 {
    public static void main(String[] args) {
        System.out.println(scoreOfString("hello"));
    }


    public static int scoreOfString(String s) {
        int sum = 0;

        int first = s.charAt(0);

        for (int i = 1; i < s.length(); i++) {
            char current = s.charAt(i);

            sum += Math.abs(first - current);
            first = current;
        }

        return sum;
    }
}
