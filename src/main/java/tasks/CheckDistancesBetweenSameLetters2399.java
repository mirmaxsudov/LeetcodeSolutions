package tasks;

import java.util.Arrays;

public class CheckDistancesBetweenSameLetters2399 {
    public static void main(String[] args) {

    }

    public static boolean checkDistances(String s, int[] distance) {
        int[] indexes = new int[s.length()];

        Arrays.fill(indexes, -1);

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (indexes[ch - 'a'] == -1)
                indexes[ch - 'a'] = i;
            else {
                if (i - indexes[ch - 'a'] != distance[i])
                    return false;
            }
        }

        return true;
    }
}