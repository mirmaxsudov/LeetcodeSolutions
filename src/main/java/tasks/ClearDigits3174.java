package tasks;

import java.util.Stack;

public class ClearDigits3174 {
    public static void main(String[] args) {
        System.out.println(clearDigits("abc"));
        System.out.println(clearDigits("cb34"));
    }

    public static String clearDigits2(String s) {
        Stack<Character> st = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                if (st.empty())
                    continue;

                st.pop();
            } else
                st.push(ch);
        }

        char[] res = new char[st.size()];

        for (int i = 0; i < st.size(); i++)
            res[i] = st.get(i);

        return new String(res);
    }

    public static String clearDigits(String s) {
        boolean[] isUsed = new boolean[s.length()];

        char[] chars = s.toCharArray();
        int len = chars.length;

        int indexOfLastLetter = -1;

        for (int i = 0; i < len; i++) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                isUsed[i] = true;

                for (int j = Math.max(indexOfLastLetter, i - 1); j >= 0; j--) {
                    if (Character.isAlphabetic(chars[j]) && !isUsed[j]) {
                        isUsed[j] = true;
                        indexOfLastLetter = j;
                        break;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < isUsed.length; i++) {
            if (!isUsed[i]) {
                sb.append(chars[i]);
            }
        }

        return sb.toString();
    }
}
