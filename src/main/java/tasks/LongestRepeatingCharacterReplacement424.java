package tasks;

public class LongestRepeatingCharacterReplacement424 {
    public static void main(String[] args) {
        System.out.println(characterReplacement("AAAA", 0));
    }

    public static int characterReplacement(String s, int k) {
        int[] c = new int[26];
        int l = 0, r = 0;

        int maxFreq = 0;
        int res = 0;

        while (r < s.length()) {
            maxFreq = Math.max(maxFreq, ++c[s.charAt(r) - 'A']);

            if (r - l + 1 - maxFreq > k) {
                c[s.charAt(l) - 'A']--;
                l++;
            }

            res = Math.max(res, r - l + 1);
            r++;
        }

        return res;
    }
}