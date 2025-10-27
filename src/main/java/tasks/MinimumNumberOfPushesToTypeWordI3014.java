package tasks;

import java.util.Arrays;

public class MinimumNumberOfPushesToTypeWordI3014 {
    public static void main(String[] args) {
        MinimumNumberOfPushesToTypeWordI3014 solution = new MinimumNumberOfPushesToTypeWordI3014();
        System.out.println(solution.minimumPushes("abcde"));  // Should print 5
        System.out.println(solution.minimumPushes("xycdefghij"));  // Should print 12
    }

    public int minimumPushes(String word) {
        int[] chars = new int[26];

        for (char c : word.toCharArray()) {
            chars[c - 'a']++;
        }

        Arrays.sort(chars);

        int res = 0;
        for (int i = 25; i >= 0; i--) {
            if (chars[i] == 0) continue;
            int pushes = (25 - i) / 8 + 1;
            res += chars[i] * pushes;
        }

        return res;
    }
}