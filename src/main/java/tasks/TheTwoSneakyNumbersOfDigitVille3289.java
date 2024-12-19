package tasks;

import java.util.*;

public class TheTwoSneakyNumbersOfDigitVille3289 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getSneakyNumbers(new int[]{0, 1, 1, 0})));
        System.out.println(Arrays.toString(getSneakyNumbers(new int[]{0, 3, 2, 1, 3, 2})));
        System.out.println(Arrays.toString(getSneakyNumbers(new int[]{7, 1, 5, 4, 3, 4, 6, 0, 9, 5, 8, 2})));
    }

    public static int[] getSneakyNumbers(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();

        int count = 0;
        List<Integer> list = new ArrayList<>();

        for (int num : nums) {
            mp.put(num, mp.getOrDefault(num, 0) + 1);

            if (mp.get(num) == 2) {
                count++;
                list.add(num);
            }
        }

        int[] res = new int[count];

        for (int i = 0; i < count; i++)
            res[i] = list.get(i);

        return res;
    }
}