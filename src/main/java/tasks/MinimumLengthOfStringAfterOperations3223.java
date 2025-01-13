package tasks;

public class MinimumLengthOfStringAfterOperations3223 {
    public static void main(String[] args) {
        System.out.println(minimumLength("abaacbcbb"));
        System.out.println(minimumLength("aa"));
    }

    public static int minimumLength(String s) {
        int[] f = new int[26];
        int l = 0;

        for (char c : s.toCharArray())
            f[c - 'a']++;

        for (int v : f) {
            if (v == 0)
                continue;
            if ((v & 1) == 0)
                l += 2;
            else
                l++;
        }

        return l;
    }
}