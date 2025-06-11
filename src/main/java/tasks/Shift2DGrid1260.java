package tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Shift2DGrid1260 {
    public static void main(String[] args) {
        System.out.println(1 % 9);
        System.out.println(shiftGrid(
                new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}},
                5
        ));
    }

    public static List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int[] array = new int[grid.length * grid[0].length];
        int i = 0;

        for (int[] nums : grid)
            for (int num : nums)
                array[i++] = num;

        int diff = k % grid.length * grid[0].length;
        int[] helper = new int[grid.length * grid[0].length];

        for (i = 0; i < grid.length * grid[0].length - diff; i++)
            helper[i + diff] = array[i];
        i = 0;
        for (int j = grid.length * grid[0].length - 1; j >= grid.length * grid[0].length - diff; j--)
            helper[i++] = array[j];

        List<List<Integer>> res = new ArrayList<>();

        int count = grid.length;

        for (i = 0; i < grid.length * grid[0].length; i += count) {
            List<Integer> sub = new ArrayList<>();
            for (int j = i; j < i + count; j++) {
                sub.add(helper[j]);
            }
            res.add(sub);
        }

        return res;
    }
}