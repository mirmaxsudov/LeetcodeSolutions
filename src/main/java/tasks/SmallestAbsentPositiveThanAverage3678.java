package tasks;

import java.util.HashSet;
import java.util.Set;

public class SmallestAbsentPositiveThanAverage3678 {
    public static void main(String[] args) {

    }

    public int smallestAbsent(int[] nums) {
        int sum = 0;
        Set<Integer> st = new HashSet<>();

        for (int num : nums) {
            sum += num;
            st.add(num);
        }

        int avg = sum / nums.length;

        for (int i = avg; i <= 100; i++)
            if (!st.contains(i))
                if (avg < i)
                    return i;

        return -1;
    }
}
