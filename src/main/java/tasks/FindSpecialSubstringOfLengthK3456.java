package tasks;

import java.util.HashSet;
import java.util.Set;

public class FindSpecialSubstringOfLengthK3456 {
    public static void main(String[] args) {

    }

    public static boolean hasSpecialSubstring(String s, int k) {
        String sub = s.substring(0, k);

        Set<Character> st = new HashSet<>();

        for (char c : sub.toCharArray()) st.add(c);

        for (int i = 0; i < s.length(); i++) {
            
        }

        return false;
    }
}