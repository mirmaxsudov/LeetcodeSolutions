package tasks;

public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("tab a cat"));
    }

    public static boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;

        String ls = s.toLowerCase();

        while (l < r) {
            if (!(Character.isAlphabetic(ls.charAt(l)) || Character.isDigit(ls.charAt(l)))) {
                l++;
                continue;
            }
            if (!(Character.isAlphabetic(ls.charAt(r))) || Character.isDigit(ls.charAt(r))) {
                r--;
                continue;
            }
            if (ls.charAt(l++) != ls.charAt(r--))
                return false;
        }

        return true;
    }
}
