package tasks;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {

    }

    public static int longestConsecutive(int[] nums) {
        Set<Integer> s = new HashSet<>();

        for (int num : nums)
            s.add(num);

        int rs = 0;

        for (int num : nums) {
            if (!s.contains(num - 1)) {
                int l = 1;
                while (s.contains(num + l))
                    l++;

                rs = Math.max(rs, l);
            }
        }

        return rs;
    }
}
