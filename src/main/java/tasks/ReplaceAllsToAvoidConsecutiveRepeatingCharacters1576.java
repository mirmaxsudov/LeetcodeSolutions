package tasks;

public class ReplaceAllsToAvoidConsecutiveRepeatingCharacters1576 {
    public static void main(String[] args) {
        System.out.println(modifyString("z?a"));
        System.out.println(modifyString("a?a"));
        System.out.println(modifyString("b?c"));
        System.out.println(modifyString("?"));
        System.out.println(modifyString("???"));
        System.out.println(modifyString("?zs"));
        System.out.println(modifyString("ubv?w"));
        System.out.println(modifyString("??yw?ipkj?"));
        System.out.println(modifyString("wz???a??n"));
    }

    public static String modifyString(String s) {
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '?')
                continue;

            if (i == 0) {
                if (chars.length > 1 && chars[i + 1] == 'a')
                    chars[i] = 'z';
                else
                    chars[i] = 'a';

                continue;
            }

            if (i == s.length() - 1) {
                if (chars[i - 1] == 'a')
                    chars[i] = 'b';
                else
                    chars[i] = 'a';

                continue;
            }

            if (chars[i + 1] == '?') {
                if (chars[i - 1] == 'z') {
                    chars[i] = 'a';
                } else {
                    chars[i] = (char) (chars[i - 1] + 1);
                }

                continue;
            }

            if (chars[i - 1] == chars[i + 1]) {
                if (chars[i - 1] == 'a') {
                    chars[i] = (char) (chars[i - 1] + 1);
                } else {
                    chars[i] = (char) (chars[i - 1] - 1);
                }

                continue;
            }

            if (Math.abs(chars[i - 1] - chars[i + 1]) == 1
                    || ((chars[i - 1] == 'a'
                    || chars[i - 1] == 'z')
                    && (chars[i - 1] == 'z'
                    || chars[i - 1] == 'a'))) {
                chars[i] = findValue(chars[i - 1], chars[i + 1]);
                continue;
            }

            chars[i] = (char) (chars[i - 1] + 1);
        }

        return new String(chars);
    }

    private static char findValue(char ch1, char ch2) {
        for (int i = 'a'; i <= 'z'; i++)
            if (ch1 != i && ch2 != i)
                return (char) i;

        return 'a';
    }
}