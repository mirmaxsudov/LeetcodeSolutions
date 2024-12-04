package tasks;

import java.util.HashMap;
import java.util.Map;

public class ValidNumber65 {
    public static void main(String[] args) {
        System.out.println(isNumber("0"));
        System.out.println(isNumber("e"));
        System.out.println(isNumber("."));
        System.out.println(isNumber("-123.456e789"));
        System.out.println(isNumber("+6e-1"));
        System.out.println(isNumber("1e."));
        System.out.println(isNumber("-1."));
        System.out.println(isNumber(".1"));
    }

    public static boolean isNumber(String s) {
        Map<Character, Boolean> mp = new HashMap<>();

        for (char c : s.toCharArray()) {
//            mp.
        }

        return false;
    }
}