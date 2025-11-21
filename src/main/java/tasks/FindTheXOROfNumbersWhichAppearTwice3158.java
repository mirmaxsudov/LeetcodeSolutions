package tasks;

import java.util.HashSet;
import java.util.Set;

public class FindTheXOROfNumbersWhichAppearTwice3158 {
    public static void main(String[] args) {

    }

    public static int duplicateNumbersXOR(int[] nums) {
        int res = 0;

        Set<Integer> st = new HashSet<>();

        for (int num : nums)
            if (!st.add(num))
                res ^= num;

        return res;
    }

    public static int duplicateNumbersXORVer(int[] nums) {
        int res = 0;

        int[] array = new int[51];

        for (int num : nums) {
            if (array[num] == 0)
                array[num] = 1;
            else
                res ^= num;
        }

        return res;
    }
}
