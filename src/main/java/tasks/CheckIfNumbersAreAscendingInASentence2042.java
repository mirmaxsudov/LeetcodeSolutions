package tasks;

public class CheckIfNumbersAreAscendingInASentence2042 {
    public static void main(String[] args) {
        System.out.println(areNumbersAscending("1 box has 3 blue 4 red 6 green and 12 yellow marbles"));
        System.out.println(areNumbersAscending("hello world 5 x 5"));
        System.out.println(areNumbersAscending("4 5 11 26"));
        System.out.println(areNumbersAscending("2 happy 2 ice days"));
    }

    public static boolean areNumbersAscending(String s) {
        int crn = 0;
        int prev = Integer.MIN_VALUE;
        boolean isCompared = false;

        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                if (isCompared)
                    continue;

                if (crn <= prev)
                    return false;

                prev = crn;
                isCompared = true;
                crn = 0;
                continue;
            }

            crn *= 10;
            crn += s.charAt(i) - '0';
            isCompared = false;

            if (i == s.length() - 1)
                return prev < crn;
        }

        return true;
    }
}