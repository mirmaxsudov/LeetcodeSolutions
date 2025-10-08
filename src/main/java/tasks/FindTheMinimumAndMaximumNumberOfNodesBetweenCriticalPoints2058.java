package tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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

//        System.out.println(Arrays.toString(nodesBetweenCriticalPoints(root)));

        var main = new FindTheMinimumAndMaximumNumberOfNodesBetweenCriticalPoints2058();
//        System.out.println(Arrays.toString(main.nodesBetweenCriticalPoints(new ListNode(5, new ListNode(3, new ListNode(1, new ListNode(2, new ListNode(5, new ListNode(1, new ListNode(2))))))))));
        System.out.println(Arrays.toString(main.nodesBetweenCriticalPoints(new ListNode(6, new ListNode(8, new ListNode(4, new ListNode(1, new ListNode(9, new ListNode(6, new ListNode(6, new ListNode(10, new ListNode(6))))))))))));
    }

    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return new int[]{-1, -1};

        List<Integer> points = new ArrayList<>();

        ListNode prev = head;
        head = head.next;

        int index = 1;

        while (head.next != null) {
            if (head.val > prev.val && head.val > head.next.val) {
                points.add(index + 1);
            } else if (head.val < prev.val && head.val < head.next.val) {
                points.add(index + 1);
            }

            index++;
            prev = prev.next;
            head = head.next;
        }

        if (points.isEmpty())
            return new int[]{-1, -1};

        System.out.println("points = " + points);

        Collections.sort(points);

        int min = points.get(1) - points.getFirst();

        for (int i = 0; i < points.size(); i++)
            for (int j = i + 1; j < points.size(); j++)
                min = Math.min(min, Math.abs(points.get(i) - points.get(j)));

        return new int[]{min, points.getLast() - points.getFirst()};
    }
}