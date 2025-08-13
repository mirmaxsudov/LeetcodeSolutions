package tasks;

import java.util.HashMap;
import java.util.Map;

public class MinimumNumberOfPushesToTypeWordI3014 {
    public static void main(String[] args) {

    }

    public static int minimumPushes(String word) {
        Map<Character, Integer> mp = new HashMap<>();
        mp.put('a', 1);
        mp.put('b', 2);
        mp.put('c', 3);
        mp.put('d', 1);
        mp.put('e', 2);
        mp.put('f', 3);
        mp.put('g', 1);
        mp.put('h', 2);
        mp.put('i', 3);
        mp.put('j', 1);
        mp.put('k', 2);
        mp.put('l', 3);
        mp.put('m', 1);
        mp.put('n', 2);
        mp.put('o', 3);
        mp.put('p', 1);
        mp.put('q', 2);
        mp.put('r', 3);
        mp.put('s', 4);
        mp.put('t', 1);
        mp.put('u', 2);
        mp.put('v', 3);
        mp.put('w', 1);
        mp.put('x', 2);
        mp.put('y', 3);
        mp.put('z', 4);

        int sum = 0;

        for (char c : word.toCharArray())
            sum += mp.get(c);

        return sum;
    }
}