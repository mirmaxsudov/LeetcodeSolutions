package tasks;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class RestoreFinishingOrder3668 {
    public static void main(String[] args) {
        RestoreFinishingOrder3668 main = new RestoreFinishingOrder3668();
        System.out.println(Arrays.toString(main.recoverOrder(new int[]{3, 1, 2, 5, 4}, new int[]{1, 3, 4})));
    }

    public int[] recoverOrder(int[] order, int[] friends) {
        int[] res = new int[friends.length];

        Map<Integer, Boolean> mp = new LinkedHashMap<>();

        for (int or : order)
            mp.put(or, false);

        for (int friend : friends)
            mp.put(friend, true);

        int i = 0;
        for (Map.Entry<Integer, Boolean> en : mp.entrySet())
            if (en.getValue())
                res[i++] = en.getKey();

        return res;
    }
}