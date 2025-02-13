package tasks;

import java.util.PriorityQueue;
import java.util.Stack;

public class MinimumOperationsToExceedThresholdValueII3066 {
    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{2, 11, 10, 1, 3}, 10));
    }

    static class MinStack {
        private final Stack<Integer> stack;
        private final PriorityQueue<Integer> minHeap;

        public MinStack() {
            stack = new Stack<>();
            minHeap = new PriorityQueue<>();
        }

        public int size() {
            return stack.size();
        }

        public void push(int val) {
            stack.push(val);
            minHeap.add(val);
        }

        public void pop() {
            if (!stack.isEmpty()) {
                int removed = stack.pop();
                minHeap.remove(removed);
            }
        }

        public int top() {
            return stack.isEmpty() ? -1 : stack.peek();
        }

        public int getMin() {
            if (minHeap.isEmpty()) return -1;
            return minHeap.poll();
        }

        @Override
        public String toString() {
            return "Stack: " + stack.toString() + "\nMinHeap: " + minHeap.toString();
        }
    }

    public static int minOperations(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            if (num < k) pq.add(num);
        }

        int operations = 0;

        while (!pq.isEmpty()) {
            int x = pq.poll();
            operations++;

            if (pq.isEmpty()) break;

            int y = pq.poll();
            long newValue = 2L * x + y;

            if (newValue < k) pq.add((int) newValue);
        }

        return operations;
    }

//    public static int minOperations(int[] nums, int k) {
//        List<Long> list = new ArrayList<>(nums.length);
//        int operationCount = 0;
//
//        for (int num : nums)
//            list.add((long) num);
//
//        while (list.size() >= 2) {
//            long f = getMinAndRemove(list);
//
//            if (f >= k)
//                break;
//
//            long s = getMinAndRemove(list);
//
//            long newNum = Math.min(f, s) * 2 + Math.max(f, s);
//
//            list.add(newNum);
//            operationCount++;
//        }
//
//        return operationCount;
//    }
//
//    private static long getMinAndRemove(List<Long> list) {
//        long min = list.getFirst();
//        int i = 0;
//
//        for (int j = 0; j < list.size(); j++) {
//            if (list.get(j) <= min) {
//                i = j;
//                min = list.get(j);
//            }
//        }
//
//        list.remove(i);
//        return min;
//    }
}