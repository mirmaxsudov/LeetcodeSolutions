package tasks;

import java.util.Arrays;
import java.util.List;

public class TheKWeakestRowsInAMatrix1337 {
    public static void main(String[] args) {

    }

    public static int[] kWeakestRows(int[][] mat, int k) {
        Pair[] pairs = new Pair[mat.length];

        int i = 0;
        for (int[] nums : mat) {
            int c = 0;
            for (int num : nums) {
                if (num == 0)
                    break;
                c++;
            }

            pairs[i] = new Pair(i++, c);
        }

        Arrays.sort(pairs);

        int[] res = new int[k];

        for (int j = 0; j < k; j++)
            res[i] = pairs[i].row;

        return res;
    }

    static class Pair implements Comparable<Pair> {
        int row;
        Integer count;

        public Pair(int row, int count) {
            this.row = row;
            this.count = count;
        }

        @Override
        public int compareTo(Pair o) {
            return count.compareTo(o.count);
        }
    }
}