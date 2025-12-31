package tasks;

import java.util.HashMap;
import java.util.Map;

public class CheckArrayFormationThroughConcatenation1640 {
    public static void main(String[] args) {
        CheckArrayFormationThroughConcatenation1640 main = new CheckArrayFormationThroughConcatenation1640();
        System.out.println(main.canFormArray(new int[]{91, 2, 4, 64, 5, 78, 12, 9}, new int[][]{{78, 12, 3}, {4, 64, 5}, {91, 2}}));
    }

    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, int[]> mp = new HashMap<>();

        for (int[] piece : pieces)
            mp.put(piece[0], piece);

        for (int i = 0; i < arr.length; ) {
            int num = arr[i];
            int[] val = mp.getOrDefault(num, null);
            if (val == null) return false;
            int valIndex = 1;
            for (int j = i + 1; j < i + val.length; j++)
                if (arr[j] != val[valIndex++])
                    return false;

            i += val.length;
            mp.remove(num);

        }

        return true;
    }
}