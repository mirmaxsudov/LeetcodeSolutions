package tasks;

import java.util.HashMap;
import java.util.Map;

public class CheckIfNumberHasEqualDigitCountAndDigitValue2283 {
    public static void main(String[] args) {
        System.out.println(digitCount("1210"));
    }

    public static boolean digitCount(String num) {
        Map<Integer, Integer> mp = new HashMap<>();

        for (char ch : num.toCharArray()) {
            int c = ch - '0';
            mp.put(c, mp.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < num.length(); i++)
            if (num.charAt(i) - '0' != mp.getOrDefault(i, 0))
                return false;

        return true;
    }
}