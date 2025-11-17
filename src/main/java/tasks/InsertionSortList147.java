package tasks;

import java.util.*;

public class InsertionSortList147 {
    public static void main(String[] args) {

    }

    public ListNode insertionSortList(ListNode head) {
        Queue<Integer> q = new PriorityQueue<>();

        while (head != null) {
            q.add(head.val);
            head = head.next;
        }

        ListNode res = new ListNode(-1);
        ListNode temp = res;

        while (!q.isEmpty()) {
            temp.next = new ListNode(q.poll());
            temp = temp.next;
        }

        return res.next;
    }
}
