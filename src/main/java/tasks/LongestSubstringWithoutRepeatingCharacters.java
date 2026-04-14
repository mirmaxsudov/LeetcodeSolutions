package tasks;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {

    }

    public static int lengthOfLongestSubstring(String s) {
        int max = 0;

        Set<Character> st = new HashSet<>();

        int l = 0;

        for (int i = 0; i < s.length(); i++) {
            if (st.contains(s.charAt(i))) {
                st.remove(s.charAt(l));
                l++;
            } else {
                st.add(s.charAt(i));
            }
            max = Math.max(max, i - l + 1);
        }

        return max;
    }
}