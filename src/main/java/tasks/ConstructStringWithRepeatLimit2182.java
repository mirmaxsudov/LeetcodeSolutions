package tasks;

import java.util.Map;
import java.util.TreeMap;

public class ConstructStringWithRepeatLimit2182 {
    public static void main(String[] args) {

    }

    public static String repeatLimitedString(String s, int repeatLimit) {

        Map<Character, Integer> mp = new TreeMap<>();

        for (char c : s.toCharArray())
            mp.put(c, mp.getOrDefault(c, 0) + 1);


        return null;
    }
}