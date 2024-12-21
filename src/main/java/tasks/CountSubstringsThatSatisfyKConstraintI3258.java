package tasks;

public class CountSubstringsThatSatisfyKConstraintI3258 {
    public static void main(String[] args) {

    }

    public static int countKConstraintSubstrings(String s, int k) {
        int z = 0, o = 0, t = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(j) == '0')
                    z++;
                else
                    o++;

                if (z <= k || o <= k)
                    t++;
                else
                    break;
            }

            o = 0;
            z = 0;
        }

        return t;
    }
}