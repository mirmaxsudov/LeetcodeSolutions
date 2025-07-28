package tasks;

import java.util.ArrayList;
import java.util.List;

public class ZigzagGridTraversalWithSkip3417 {
    public static void main(String[] args) {
        System.out.println(zigzagTraversal(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        }));
    }

    public static List<Integer> zigzagTraversal(int[][] grid) {
        List<Integer> list = new ArrayList<>();

        boolean isEven = true;

        for (int[] array : grid) {
            if (isEven) {
                for (int i = 0; i < array.length; i += 2)
                    list.add(array[i]);
            } else {
                for (int i = array.length - 2; i >= 0; i -= 2)
                    list.add(array[i]);
            }

            isEven = !isEven;
        }

        return list;
    }
}