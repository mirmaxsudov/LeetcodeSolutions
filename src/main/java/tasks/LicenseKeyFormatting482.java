package tasks;

public class LicenseKeyFormatting482 {
    public static void main(String[] args) {
        System.out.println(licenseKeyFormatting("5F3Z-2e-9-w", 4));
        System.out.println(licenseKeyFormatting("2-5g-3-J", 2));
    }

    public static String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index < s.length()) {
            char c = s.charAt(index);

            if (c == '-') {
                if (index + 1 <= k) {
                    sb.append(s, 0, index);
                    sb.append("-");
                } else {
                    sb.append(s, 0, k);
                    sb.append("-");
                    index = k;
                }
                break;
            }
            index++;
        }

        int count = 0;

        for (int i = index; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '-')
                continue;

            if (ch >= 97)
                sb.append((char) (ch - 32));
            else
                sb.append(ch);

            count++;

            if (count == k) {
                if (s.length() - 1 != i)
                    sb.append("-");
                count = 0;
            }
        }

        return sb.toString();
    }
}