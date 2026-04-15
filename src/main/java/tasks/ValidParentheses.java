package tasks;

import java.util.Set;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {

    }

    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        Set<Character> set = Set.of('(', '{', '[');

        for (char cha : s.toCharArray()) {
            if (set.contains(cha)) {
                st.add(cha);
            } else {
                if (st.isEmpty())
                    return false;
                if (cha == ')' && st.pop() != '(')
                    return false;
                else if (cha == '}' && st.pop() != '{')
                    return false;
                else if (cha == ']' && st.pop() != '[')
                    return false;
            }
        }

        return st.isEmpty();
    }
}
