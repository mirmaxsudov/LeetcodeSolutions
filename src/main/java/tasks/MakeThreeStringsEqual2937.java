package tasks;

public class MakeThreeStringsEqual2937 {
    public static void main(String[] args) {
        System.out.println(findMinimumOperations("abc", "abb", "ab"));
        System.out.println(findMinimumOperations("dac", "bac", "cac"));
    }

    public static int findMinimumOperations(String s1, String s2, String s3) {
        int i = 0;

        while ((s1.length() > i && s2.length() > i && s3.length() > i) && s1.charAt(i) == s2.charAt(i) && s1.charAt(i) == s3.charAt(i))
            i++;

        if (i == 0)
            return -1;

        return s1.length() - i + s2.length() - i + s3.length() - i;
    }
}