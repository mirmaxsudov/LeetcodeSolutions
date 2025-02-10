package tasks;

import java.util.Stack;

public class ValidParentheses20 {
    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("{[]}"));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[')
                stack.push(ch);
            else {
                if (ch == ')') {
                    if (stack.isEmpty() || stack.pop() != '(')
                        return false;
                } else if (ch == ']') {
                    if (stack.isEmpty() || stack.pop() != '[')
                        return false;
                } else if (ch == '}') {
                    if (stack.isEmpty() || stack.pop() != '{')
                        return false;
                } else
                    return false;
            }
        }

        return stack.isEmpty();
    }
}