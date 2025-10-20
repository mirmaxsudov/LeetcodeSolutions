package tasks;

import java.util.HashSet;
import java.util.Set;

public class ExistenceOfASubstringInAStringAndItsReverse3083 {
    public static void main(String[] args) {
        ExistenceOfASubstringInAStringAndItsReverse3083 sol = new ExistenceOfASubstringInAStringAndItsReverse3083();
        System.out.println(sol.isSubstringPresent("leetcode"));
    }

    public boolean isSubstringPresent(String s) {
        Set<String> st = new HashSet<>();

        for (int i = 0; i < s.length() - 1; i++)
            st.add(s.substring(i, i + 2));

        for (int i = s.length() - 1; i >= 1; i--)
            if (st.contains(s.charAt(i - 1) + "" + s.charAt(i)))
                return true;

        return false;
    }
}
