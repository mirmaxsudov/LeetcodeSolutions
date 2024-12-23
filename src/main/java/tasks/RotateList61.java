package tasks;

public class RotateList61 {
    public static void main(String[] args) {
        rotateRight(
                new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))),
                2
        );
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null)
            return null;

        int length = length(head);

        if (length == 1 || length == 0 || k == 0)
            return head;

        int step = length - (k % length);

        if (step - length == 0)
            return head;

        ListNode first = head;

        for (int i = step; i != 1; i--)
            first = first.next;

        ListNode temp = head;

        head = first.next;

        first.next = null;

        ListNode second = head;

        while (second.next != null)
            second = second.next;

        second.next = temp;

        return head;
    }

    public static int length(ListNode list) {
        if (list == null)
            return 0;

        return 1 + length(list.next);
    }
}