package tasks;

import java.util.Arrays;
import java.util.PriorityQueue;

public class FinalArrayStateAfterKMultiplicationOperationsI3264 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getFinalState(new int[]{1, 2, 3, 4}, 2, 3)));
        System.out.println(Arrays.toString(getFinalStateV2(new int[]{1, 2, 3, 4}, 2, 3)));
    }

    public static int[] getFinalStateV2(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
                (a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0])
        );

        for (int i = 0; i < nums.length; i++) {
            minHeap.offer(new int[]{nums[i], i});
        }

        for (int i = 0; i < k; i++) {
            int[] curr = minHeap.poll();
            int in = curr[1];
            nums[in] = curr[0] * multiplier;
            minHeap.offer(new int[]{nums[i], i});
        }

        return nums;
    }

    public static int[] getFinalState(int[] nums, int k, int multiplier) {
        for (int i = 0; i < k; i++) {
            int min = Integer.MAX_VALUE;
            int index = -1;

            for (int j = 0; j < nums.length; j++)
                if (nums[j] < min) {
                    min = nums[j];
                    index = j;
                }

            if (index != -1)
                nums[index] *= multiplier;
        }

        return nums;
    }
}