package tasks;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindSpecialSubstringOfLengthK3456 {
    public static void main(String[] args) {
        System.out.println(hasSpecialSubstring("aaaabaa", 3));
        System.out.println(hasSpecialSubstring("jkjhfgg", 2));
        System.out.println(hasSpecialSubstring("ededaee", 3));
        System.out.println(hasSpecialSubstring("jjadddjj", 3));
    }

    public static boolean hasSpecialSubstringVer2(String s, int k) {
        int count = 1;
        for (int i = s.length() - 2; i >= 0; i--) {
            if (s.charAt(i) == s.charAt(i - 1))
                count++;
            else {
                if (count == k)
                    return true;
                count = 1;
            }
        }

        return count == k;
    }

    public static boolean hasSpecialSubstring(String s, int k) {
        Map<Character, Integer> st = new HashMap<>();
        int len = s.length();

        for (int i = 0; i < k; i++)
            st.put(s.charAt(i), st.getOrDefault(s.charAt(i), 0) + 1);

        if (st.size() == 1 && len == k)
            return true;

        if (len > k)
            if (st.size() == 1 && s.charAt(k) != s.charAt(0))
                return true;

        for (int i = 1; i < len - k; i++) {
            // Remove
            if (st.get(s.charAt(i - 1)) - 1 == 0)
                st.remove(s.charAt(i - 1));
            else
                st.put(s.charAt(i - 1), st.get(s.charAt(i - 1)) - 1);

            // Add
            st.put(s.charAt(i + k - 1), st.getOrDefault(s.charAt(i + k - 1), 0) + 1);

            if (st.size() != 1)
                continue;

            if (s.charAt(i - 1) != s.charAt(i) && s.charAt(i + k) != s.charAt(i))
                return true;
        }

        if (s.length() == k)
            return false;

        st.clear();

        for (int i = len - k; i < len; i++)
            st.put(s.charAt(i), st.getOrDefault(s.charAt(i), 0) + 1);

        if (st.size() != 1)
            return false;

        return s.charAt(len - k - 1) != s.charAt(len - 1);
    }
}