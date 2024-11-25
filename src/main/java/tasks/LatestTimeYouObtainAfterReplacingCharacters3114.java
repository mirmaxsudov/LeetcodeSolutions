package tasks;

public class LatestTimeYouObtainAfterReplacingCharacters3114 {
    public static void main(String[] args) {
        System.out.println(findLatestTime("??:??"));
        System.out.println(findLatestTime("??:?4"));
        System.out.println(findLatestTime("??:4?"));
        System.out.println(findLatestTime("1?:??"));
        System.out.println(findLatestTime("?1:??"));
        System.out.println(findLatestTime("?3:12"));
    }

    public static String findLatestTime(String s) {
        String[] values = s.split(":");

        char f1 = values[0].charAt(0);
        char f2 = values[0].charAt(1);

        char s1 = values[1].charAt(0);
        char s2 = values[1].charAt(1);

        StringBuilder builder = new StringBuilder();

        if (f1 == '?') {
            if (f2 == '?')
                builder.append("1");
            else {
                if (f2 - 'a' <= 9) {
                    builder.append('0');
                    builder.append(f2);
                } else {
                    builder.append('1');
                    builder.append(f2);
                }
            }
        } else {
            if (f2 != '?')
                builder.append(f2);
            else {
                if (s1 == '0')
                    builder.append('9');
                else
                    builder.append('0');
            }
        }

        builder.append(":");

        if (s1 == '?') {
            builder.append("5");
        } else {
            builder.append(s1);
        }

        if (s2 == '?')
            builder.append("9");
        else
            builder.append(s2);

        return builder.toString();
    }
}