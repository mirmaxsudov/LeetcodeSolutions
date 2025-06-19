package tasks;

public class SubstringMatchingPattern3407 {
    public static void main(String[] args) {
        System.out.println(hasMatch("leetcode", "ee*e"));
        System.out.println(hasMatch("car", "c*v"));
        System.out.println(hasMatch("luck", "u*"));
        System.out.println(hasMatch("l", "*"));
        System.out.println(hasMatch("tokk", "t*t"));
        System.out.println(hasMatch("ckckkk", "ck*kc"));
    }

    public static boolean hasMatch(String s, String p) {
        String[] values = p.split("\\*");

        int len = values.length;
        if (len == 0)
            return true;

        String first = values[0];
        String second = values[1];
        boolean secondBlank = second.isBlank();
        boolean firstBlank = first.isBlank();

        if (firstBlank && secondBlank)
            return true;

        if (firstBlank)
            return s.contains(second);

        if (len == 2 && secondBlank)
            return s.contains(first);

        int fi = s.indexOf(first);

        if (fi == -1)
            return false;

        int si = s.indexOf(second, fi + first.length());

        return si != -1;
    }
}