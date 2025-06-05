package tasks;

import java.util.HashMap;
import java.util.Map;

public class ValidNumber65 {
    public static void main(String[] args) {
//        System.out.println(isNumber("0"));
//        System.out.println(isNumber("e"));
//        System.out.println(isNumber("."));
//        System.out.println(isNumber("-123.456e789"));
//        System.out.println(isNumber("+6e-1"));
//        System.out.println(isNumber("1e."));
//        System.out.println(isNumber("-1."));
//        System.out.println(isNumber(".1"));
//        System.out.println(isNumber("-1E+3"));
//        System.out.println(isNumber(".."));
//        System.out.println(isNumber("6+1"));
//        System.out.println(isNumber("+."));
//        System.out.println(isNumber("+E3"));
//        System.out.println(isNumber("0e1"));
//        System.out.println(isNumber(".0e7"));
        System.out.println(isNumber("46.e3"));
        System.out.println(isNumber(".e1"));
    }

    public static boolean isNumber(String s) {
        boolean isFindDot = false;
        boolean isFindE = false;
        int eIndex = -1;
        boolean isFindNumber = false;

        for (int i = 0; i < s.toCharArray().length; i++) {
            char c = s.charAt(i);

            if (c == '+' || c == '-') {
                if (i == 0) {
                    if (s.length() == 1)
                        return false;
                    continue;
                }

                if (i != 0) {
                    if (!isFindE || i - eIndex != 1 || (i == s.length() - 1))
                        return false;
                    continue;
                }
            }

            if (c == '.') {
                if (isFindE || (s.length() == 1) || isFindDot || i != 0 && (!Character.isDigit(s.charAt(i - 1)) && i == s.length() - 1))
                    return false;

                isFindDot = true;
                continue;
            }

            if (c == 'e' || c == 'E') {
                if (isFindE || i == 0 || (i == s.length() - 1) || !isFindNumber)
                    return false;

                isFindE = true;
                eIndex = i;
                continue;
            }

            if (!Character.isDigit(c))
                return false;

            isFindNumber = true;
        }

        return true;
    }
}