package tasks;

import java.util.ArrayList;
import java.util.List;

public class CheckIfOneStringSwapCanMakeStringsEqual1790 {
    public static void main(String[] args) {
        System.out.println(areAlmostEqual("bank", "kanb"));
        System.out.println(areAlmostEqual("attack", "defend"));
        System.out.println(areAlmostEqual("kelb", "kelb"));
        System.out.println(areAlmostEqual("caa", "aaz"));
    }

    public static boolean areAlmostEqual(String s1, String s2) {
        byte set = 0;
        int f = -1;
        int s = -1;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(i))
                continue;

            switch (set) {
                case 0 -> f = i;
                case 1 -> s = i;
                default -> {
                    return false;
                }
            }

            set++;
        }

        if (set <= 1)
            return set != 1;

        return s1.charAt(f) == s2.charAt(s) && s1.charAt(s) == s2.charAt(f);
    }
}