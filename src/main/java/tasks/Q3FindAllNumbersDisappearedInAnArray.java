package tasks;

import java.util.*;

public class Q3FindAllNumbersDisappearedInAnArray {
    public static void main(String[] args) {

    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> r = new ArrayList<>();

        Set<Integer> st = new HashSet<>();

        for (int num : nums)
            st.add(num);

        for (int i = 1; i <= nums.length; i++)
            if (!st.add(i))
                r.add(i);

        return r;
    }
}
