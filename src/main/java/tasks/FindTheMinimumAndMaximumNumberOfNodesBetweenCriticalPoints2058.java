package tasks;

import java.util.Arrays;

public class FindTheMinimumAndMaximumNumberOfNodesBetweenCriticalPoints2058 {
    public static void main(String[] args) {
//        5,3,1,2,5,1,2
        ListNode root = new ListNode(5,
                new ListNode(3,
                        new ListNode(1,
                                new ListNode(2,
                                        new ListNode(5,
                                                new ListNode(1,
                                                        new ListNode(2)))))));

//        1,3,2,2,3,2,2,2,7
//        ListNode root = new ListNode(1,
//                new ListNode(3,
//                        new ListNode(2,
//                                new ListNode(2,
//                                        new ListNode(3,
//                                                new ListNode(2,
//                                                        new ListNode(2,
//                                                                new ListNode(2,
//                                                                        new ListNode(7, null)))))))));

        System.out.println(Arrays.toString(nodesBetweenCriticalPoints(root)));
    }

    public static int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode prev = head;
        head = head.next;
        int i = 1;
        int indexMaxima = -1;
        int secondMaxima = -1;
        int indexMinima = -1;

        while (head != null && head.next != null) {
            int prevVal = prev.val;
            int current = head.val;
            int next = head.next.val;
            i++;

            prev = prev.next;
            head = head.next;

            if (prevVal > current && next > current) {
                if (indexMinima == -1)
                    indexMinima = i;
                else {
                    if (indexMaxima != -1)
                        secondMaxima = indexMaxima;

                    indexMaxima = i;
                }
                continue;
            }

            if (current > prevVal && current > next) {
                if (indexMaxima != -1)
                    secondMaxima = indexMaxima;

                indexMaxima = i;
                continue;
            }
        }

        if (indexMaxima == indexMinima)
            return new int[]{-1, -1};

        if (indexMinima == -1 && secondMaxima != -1)
            return new int[]{indexMaxima - secondMaxima, indexMaxima - secondMaxima};

        if (indexMaxima == -1)
            return new int[]{indexMinima, indexMinima};

        return new int[]{indexMaxima - indexMinima, indexMaxima - secondMaxima};
    }
}