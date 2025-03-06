package tasks;

import java.util.Arrays;

public class FindMissingAndRepeatedValues2965 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findMissingAndRepeatedValues(
                new int[][]{{
                        1, 3
                }, {
                        2, 2
                }}
        )));
        System.out.println(Arrays.toString(findMissingAndRepeatedValues(
                new int[][]{{
                        9, 1, 7
                }, {
                        8, 9, 2
                }, {
                        3, 4, 6
                }}
        )));
        System.out.println(Arrays.toString(findMissingAndRepeatedValues(
                new int[][]{{
                        2, 3
                }, {
                        4, 3
                }}
        )));
    }

    public static int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] arr = new int[grid.length * grid[0].length];
        int i = 0;

        for (int[] array : grid)
            for (int num : array)
                arr[i++] = num;

        Arrays.sort(arr);

        int missing = -1;
        int repeated = -1;

        boolean isFirstTime = true;

        boolean isFoundRepeated = false;
        boolean isFoundMissing = false;

        for (int num : arr) {
            if (isFoundMissing && isFoundRepeated)
                break;

            if (!isFoundRepeated) {
                if (repeated == -1) {
                    repeated = num;
                } else if (num == repeated) {
                    isFoundRepeated = true;
                } else {
                    repeated = num;
                }
            }

            if (!isFoundMissing) {
                if (isFirstTime) {
                    isFirstTime = false;
                    missing = num;

                    if (num != 1) {
                        isFoundMissing = true;
                        missing = 1;
                        continue;
                    }
                }

                if (num == missing + 1)
                    missing++;
                else if (num == missing + 2) {
                    missing++;
                    isFoundMissing = true;
                }
            }
        }

        if (missing == arr[arr.length - 1])
            missing++;

        return new int[]{repeated, missing};
    }
}