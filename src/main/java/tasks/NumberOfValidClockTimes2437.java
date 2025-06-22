package tasks;

public class NumberOfValidClockTimes2437 {
    public static void main(String[] args) {

    }

    public static int countTime(String time) {
        int res = 1;

        if (time.startsWith("??")) {
            res *= 24;
        }

        return res;
    }
}