package tasks;

public class FindTheOriginalTypedStringI3330 {
    public static void main(String[] args) {
        System.out.println(possibleStringCount("abbcccc"));
        System.out.println(possibleStringCount("abcd"));
    }

    public static int possibleStringCount(String word) {
        int count = 1;
        int iC = 1;
        char c = word.charAt(0);

        for (int i = 1; i < word.length(); i++) {
            char t = word.charAt(i);
            if (c == t)
                iC++;
            else {
                if (iC >= 2)
                    count += iC - 1;

                c = t;
                iC = 1;
            }
        }

        if (iC >= 2)
            count += iC - 1;

        return count;
    }
}