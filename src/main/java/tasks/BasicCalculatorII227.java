package tasks;

import java.util.Stack;

public class BasicCalculatorII227 {
    public static void main(String[] args) {
        System.out.println(calculate("2 + 3 * 2 + 5 * 2"));
        System.out.println(calculate("3+2*2"));
        System.out.println(calculate("31343+2*2"));
    }

    public static int calculate(String s) {
        if (s == null || s.isBlank())
            return 0;

        Stack<Integer> st = new Stack<>();
        int num = 0;
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == s.length() - 1) {
                switch (sign) {
                    case '+' -> st.push(num);
                    case '-' -> st.push(-num);
                    case '*' -> st.push(num * st.pop());
                    case '/' -> st.push(st.pop() / num);
                }

                sign = s.charAt(i);
                num = 0;
            }
        }

        int res = 0;

        for (int n : st)
            res += n;

        return res;
    }
}

//

// 2 + 3 * 2 + 5 * 2
// 2 + 6 + 10
// 18

// 2 + 3 * 2 + 5 * 2
// [2 + 3] [2 + 5] [2]