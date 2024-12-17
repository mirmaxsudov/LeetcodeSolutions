package tasks;

import java.util.*;

@SuppressWarnings("all")
public class CreateTargetArrayInTheGivenOrder1389 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(createTargetArray(
                new int[]{0, 1, 2, 3, 4},
                new int[]{0, 1, 2, 2, 1}
        )) + " - " + "0,4,1,3,2");
    }

    public static int[] createTargetArray(int[] nums, int[] index) {
        int len = index.length;

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < len; i++)
            list.add(index[i], nums[i]);

        int[] res = new int[len];

        for (int i = 0; i < list.size(); i++)
            res[i] = list.get(i);

        return res;
    }
}