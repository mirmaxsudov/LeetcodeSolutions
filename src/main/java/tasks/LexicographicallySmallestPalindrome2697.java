package tasks;

public class LexicographicallySmallestPalindrome2697 {
    public static void main(String[] args) {

    }

    public static String makeSmallestPalindrome(String s) {
        char[] chars = s.toCharArray();

        int len = s.length();

        for (int i = 0; i <= len / 2; i++)
            chars[i] = chars[len - 1 - i] = (char) Math.min(s.charAt(i), s.charAt(len - 1 - i));

        return new String(chars);
    }
}