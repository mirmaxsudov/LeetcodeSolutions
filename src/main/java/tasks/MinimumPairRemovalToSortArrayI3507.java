package tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumPairRemovalToSortArrayI3507 {
    public static void main(String[] args) {

    }

    public static int minimumPairRemoval(int[] nums) {
        int minOp = 0;

        List<Integer> list = new ArrayList<>();

        for (int num : nums)
            list.add(num);

        while (true) {
            int num1 = 0, num2 = 0;
            boolean isFind = false;
            for (int i = list.size() - 1; i >= 1; i--) {
                if (list.get(i) < list.get(i - 1)) {
                    num1 = list.get(i);
                    num2 = list.get(i - 1);
                    isFind = true;
                    break;
                }
            }

            if (isFind) {
                list.removeLast();
                list.set(list.size() - 1, num1 + num2);
            } else {
                break;
            }
            minOp++;
        }

        return minOp;
    }
}