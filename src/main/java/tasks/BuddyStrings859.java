package tasks;

public class BuddyStrings859 {
    public static void main(String[] args) {
        System.out.println(buddyStrings("ab", "ba"));
    }

    public static boolean buddyStrings(String s, String goal) {
        int fi = -1;
        int si = -1;

        int len = s.length();

        if (len != goal.length())
            return false;

        for (int i = 0; i < len; i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                if (fi == -1) {
                    fi = i;
                } else if (si == -1) {
                    si = i;
                } else {
                    return false;
                }
            }
        }

        if (fi == -1 && si == -1)
            return true;

        return s.charAt(fi) == goal.charAt(si) && s.charAt(si) == goal.charAt(fi);
    }
}