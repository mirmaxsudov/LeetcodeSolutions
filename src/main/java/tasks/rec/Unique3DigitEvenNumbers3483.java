package tasks.rec;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Unique3DigitEvenNumbers3483 {
    public static void main(String[] args) {

    }


    public int totalNumbers(int[] digits) {
        Set<String> st = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        dfs(digits, sb, st);
        return st.size();
    }

    private void dfs(int[] digits, StringBuilder sb, Set<String> st) {
        if (sb.length() == 3) {
            st.add(sb.toString());
            return;
        }

        for (int i = 0; i < digits.length; i++) {
            if (digits[i] == -1)
                continue;

            if (sb.isEmpty() && digits[i] == 0 || sb.length() == 2 && digits[i] % 2 == 1)
                continue;

            int originNum = digits[i];

            sb.append(originNum);
            digits[i] = -1;

            dfs(digits, sb, st);
            sb.setLength(sb.length() - 1);
            digits[i] = originNum;
        }
    }
}