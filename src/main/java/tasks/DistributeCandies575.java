package tasks;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DistributeCandies575 {
    public static void main(String[] args) {

    }

    public static int distributeCandies(int[] candyType) {
        Set<Integer> st = new HashSet<>();

        for (int type : candyType)
            st.add(type);

        int half = candyType.length / 2;
        return Math.min(half, st.size());
    }
}
