package tasks;

public class NumberOfValidClockTimes2437 {
    public static void main(String[] args) {

    }

    public static int countTime(String time) {
        int res = 1;

        if (time.startsWith("??"))
            res = 24;
        else if (time.charAt(0) == '?')
            res *= (time.charAt(1)) - '0' >= 4 ? 2 : 3;
        else if (time.charAt(1) == '?')
            res *= time.charAt(0) == '2' ? 4 : 10;

        if (time.charAt(3) == '?')
            res *= 6;
        if (time.charAt(4) == '?')
            res *= 10;

        return res;
    }
}