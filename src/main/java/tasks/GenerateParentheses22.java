package tasks;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses22 {
    public static void main(String[] args) {
    }

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        bg(res, "", 0, 0, n);
        return res;
    }

    private static void bg(List<String> res, String current, int open, int close, int n) {
        if (current.length() == n * 2) {
            res.add(current);
        } else {
            if (open < n)
                bg(res, current + "(", open + 1, close, n);
            if (close < open)
                bg(res, current + ")", open, close + 1, n);
        }
    }
}