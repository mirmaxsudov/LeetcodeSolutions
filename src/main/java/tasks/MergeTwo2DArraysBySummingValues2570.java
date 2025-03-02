package tasks;

import java.util.*;

public class MergeTwo2DArraysBySummingValues2570 {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(mergeArraysVer2(new int[][]{{1, 2}, {2, 3}, {4, 5}}, new int[][]{{1, 4}, {3, 2}, {4, 1}})));
        // Res => [[1,6],[2,3],[3,2],[4,6]]
    }

    public static int[][] mergeArraysVer2(int[][] nums1, int[][] nums2) {
        Set<Integer> st = new HashSet<>();

        for (int[] ints : nums1) st.add(ints[0]);
        for (int[] ints : nums2) st.add(ints[0]);

        int[][] res = new int[st.size()][2];
        int f = 0, s = 0, index = 0;

        while (f < nums1.length && s < nums2.length) {
            if (nums1[f][0] == nums2[s][0]) {
                res[index][0] = nums1[f][0];
                res[index][1] = nums1[f][1] + nums2[s][1];
                f++;
                s++;
            } else if (nums1[f][0] > nums2[s][0]) {
                res[index][0] = nums2[s][0];
                res[index][1] = nums2[s][1];
                s++;
            } else {
                res[index][0] = nums1[f][0];
                res[index][1] = nums1[f][1];
                f++;
            }
            index++;
        }

        while (f < nums1.length) {
            res[index][0] = nums1[f][0];
            res[index++][1] = nums1[f++][1];
        }

        while (s < nums2.length) {
            res[index][0] = nums2[s][0];
            res[index++][1] = nums2[s++][1];
        }

        return res;
    }

    public static int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int f = 0, s = 0;

        List<int[]> list = new ArrayList<>();

        while (f < nums1.length && s < nums2.length) {
            if (nums1[f][0] == nums2[s][0]) {
                list.add(new int[]{nums1[f][0], nums1[f][1] + nums2[s][1]});
                f++;
                s++;
            } else if (nums1[f][0] > nums2[s][0]) {
                list.add(new int[]{nums2[s][0], nums2[s][1]});
                s++;
            } else {
                list.add(new int[]{nums1[f][0], nums1[f][1]});
                f++;
            }
        }

        while (f < nums1.length)
            list.add(new int[]{nums1[f][0], nums1[f++][1]});

        while (s < nums2.length)
            list.add(new int[]{nums2[s][0], nums2[s++][1]});

        return list.toArray(new int[list.size()][2]);
    }
}