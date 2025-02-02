package tasks;

import java.util.ArrayList;
import java.util.List;

public class SpecialArrayI3151 {
    public static void main(String[] args) {
        System.out.println(permutation(new int[]{1, 2, 3}));
    }

    public static List<List<Integer>> permutation(int[] arr) {
        if (arr.length == 0)
            return new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();



        return res;
    }

    public static boolean isArraySpecial(int[] nums) {
        if (nums.length <= 1)
            return true;

        for (int i = 1; i < nums.length; i++)
            if ((nums[i] & 1) == (nums[i] & 1))
                return false;

        return true;
    }
}