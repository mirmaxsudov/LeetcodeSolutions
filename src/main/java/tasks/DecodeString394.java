package tasks;

public class DecodeString394 {
    public static void main(String[] args) {

    }

    int i;

    public String decodeString(String s) {
        i = 0;
        return decode(s);
    }

    private String decode(String s) {
        StringBuilder sb = new StringBuilder();

        while (i < s.length()) {
            int num = 0;
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            } else if (ch == '[') {
                String inner = decode(s);
                for (int j = 0; j < num; j++) {
                    sb.append(inner);
                }
            } else if (ch == ']') {
                return sb.toString();
            } else {
                sb.append(ch);
            }
            i++;
        }

        return sb.toString();
    }
}