package tasks;

public class LongPressedName925 {
    public static void main(String[] args) {
        System.out.println(isLongPressedName("alex", "aaleex"));
        System.out.println(isLongPressedName("saeed", "ssaaedd"));
    }

    public static boolean isLongPressedName(String name, String typed) {
        int fi = 0, si = 0;

        while (fi != name.length() && si != typed.length()) {
            char fc = name.charAt(fi), sc = typed.charAt(si);

            if (fc != sc)
                return false;

            int fii = fi + 1;
            while (fii < name.length() && name.charAt(fii) == fc)
                fii++;

            int sii = si + 1;
            while (sii < typed.length() && typed.charAt(sii) == sc)
                sii++;

            int dif1 = fii - fi, dif2 = sii - si;

            if (dif1 > dif2)
                return false;

            fi = fii;
            si = sii;
        }

        return fi == name.length() && si == typed.length();
    }
}