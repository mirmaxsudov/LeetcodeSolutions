package tasks;

import java.util.HashMap;
import java.util.Map;

public class VerifyingAnAlienDictionary953 {
    public static void main(String[] args) {
        System.out.println(isAlienSorted(new String[]{"hello", "leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
    }

    public static boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> mp = new HashMap<>();

        for (int i = 0; i < order.length(); i++)
            mp.put(order.charAt(i), i);

        for (String word : words) {
            int prevIndex = -1;

            int i = 0;
            for (char c : word.toCharArray()) {
                if (prevIndex > mp.get(c))
                    return false;
                else
                    prevIndex = i;

                i++;
            }
        }

        return true;
    }
}