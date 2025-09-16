package tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MostVisitedSectorInACircularTrack1560 {
    public static void main(String[] args) {
        System.out.println(mostVisited(4, new int[]{1, 3, 1, 2}));
    }

    public static List<Integer> mostVisited(int n, int[] rounds) {
        int[] vals = new int[n];
        int max = 0;

        for (int i = 0; i < rounds.length - 1; i++) {
            int c = rounds[i], cn = rounds[i + 1];
            int minRound = Math.min(c, cn), maxRound = Math.max(c, cn);

            for (int j = minRound - 1; j < maxRound; j++)
                max = Math.max(++vals[j], max);
        }

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < vals.length; i++)
            if (vals[i] == max)
                res.add(i + 1);

        return res;
    }
}