package tasks;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortTheMatrixDiagonally1329 {
    public static void main(String[] args) {

    }

    public static int[][] diagonalSort(int[][] mat) {
        Map<Integer, PriorityQueue<Integer>> mp = new HashMap<>();

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                mp.putIfAbsent(i - j, new PriorityQueue<>());
                mp.get(i - j).add(mat[i][j]);
            }
        }


        for (int i = 0; i < mat.length; i++)
            for (int j = 0; j < mat[i].length; j++)
                mat[i][j] = mp.get(i - j).poll();

        return mat;
    }
}