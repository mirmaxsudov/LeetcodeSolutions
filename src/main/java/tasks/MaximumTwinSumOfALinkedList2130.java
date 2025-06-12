package tasks;

import java.util.Stack;

public class MaximumTwinSumOfALinkedList2130 {
    public static void main(String[] args) {
        ListNode root = new ListNode(4,
                new ListNode(2,
                        new ListNode(2,
                                new ListNode(3))));

        MaximumTwinSumOfALinkedList2130 main = new MaximumTwinSumOfALinkedList2130();
        System.out.println(main.pairSum(root));
    }

    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid = null;

        while (slow != null) {
            mid = new ListNode(slow.val, mid);
            slow = slow.next;
        }

        int max = 0;

        while (mid != null && head != null) {
            max = Math.max(max, head.val + mid.val);
            mid = mid.next;
            head = head.next;
        }

        return max;
    }
//    public int pairSum(ListNode head) {
//        Stack<Integer> st = new Stack<>();
//
//        ListNode slow = head;
//        ListNode fast = head;
//
//        while (slow != null && fast != null && fast.next != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//
//        while (slow != null) {
//            st.add(slow.val);
//            slow = slow.next;
//        }
//
//        int max = 0;
//
//        while (!st.isEmpty()) {
//            max = Math.max(max, st.pop() + head.val);
//            head = head.next;
//        }
//
//        return max;
//    }
}