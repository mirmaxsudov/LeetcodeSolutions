package tasks;

public class MinimumNumberOfChairsInAWaitingRoom3168 {
    public static void main(String[] args) {

    }

    public static int minimumChairs(String s) {
        int res = 0;
        int count = 0;
        for (char c : s.toCharArray()) {
            count += c == 'E' ? -1 : 1;
            res = Math.max(count, res);
        }

        return res;
    }
}