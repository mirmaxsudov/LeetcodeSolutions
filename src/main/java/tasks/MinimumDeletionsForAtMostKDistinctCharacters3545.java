package tasks;

import java.util.Arrays;

public class MinimumDeletionsForAtMostKDistinctCharacters3545 {
    public static void main(String[] args) {
        System.out.println(minDeletion("abc", 2));
        System.out.println(minDeletion("aabb", 2));
        System.out.println(minDeletion("yyyzz", 1));
    }

    public static int minDeletion(String s, int k) {
        int[] vals = new int[26];

        for (char ch : s.toCharArray())
            ++vals[ch - 'a'];

        Arrays.sort(vals);

        int min = 0, c = 0, i = -1;

        for (int j = 0; j < vals.length; j++) {
            if (vals[j] != 0) {
                i = j;
                break;
            } else
                c++;
        }

        int howMuch = (26 - c) - k;

        while (howMuch > 0) {
            min += vals[i++];
            howMuch--;
        }

        return min;
    }
}
