package tasks;

import java.util.Stack;

public class BasicCalculator224 {
    public static void main(String[] args) {

    }

    public static int calculate(String s) {
        int result = 0;

        Stack<Integer> stack = new Stack<>();

        s = s.replaceAll(" ", "");

        for (int i = 0; i < s.length(); i++) {
            final char ch = s.charAt(i);

            if (ch == '(') {
                stack.push(result);
            }

            if (ch == ')') {
                result = stack.pop();
            } else if (ch == '+') {
                result += stack.pop();
            } else if (ch == '-') {
                result -= stack.pop();
            } else {
                result = result * 10 + ch - '0';
            }
        }

        return result;
    }
}