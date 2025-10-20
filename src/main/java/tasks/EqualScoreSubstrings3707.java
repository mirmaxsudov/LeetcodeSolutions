package tasks;

public class EqualScoreSubstrings3707 {
    public static void main(String[] args) {
        EqualScoreSubstrings3707 obj = new EqualScoreSubstrings3707();
        System.out.println(obj.scoreBalance("ceead"));
        System.out.println(obj.scoreBalance("abdcd"));
    }

    /*
     * abdcd
     * 12434
     * */

    /*
     * ceead
     *
     * */

    public boolean scoreBalance(String s) {
        int sum = 0;

        for (char c : s.toCharArray())
            sum += Math.abs(c - 'a' + 1);

        int leftSum = 0;

        for (int i = 0; i < s.length(); i++) {
            int val = Math.abs(s.charAt(i) - 'a' + 1);
            leftSum += val;
            sum -= val;

            if (leftSum == sum)
                return true;
        }

        return false;
    }
}
