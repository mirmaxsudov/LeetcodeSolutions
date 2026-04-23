package tasks;

public class RemoveNodeFromEndOfLinkedList {
    public static void main(String[] args) {

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = size(head);
        int iterateCount = size - n;

        if (iterateCount == 0)
            return head.next;

        ListNode temp = head;
        ListNode prev = null;

        while (iterateCount-- != 0) {
            prev = temp;
            temp = temp.next;
        }

        prev.next = temp.next;

        return head;
    }

    private int size(ListNode head) {
        int size = 0;

        while (head != null) {
            head = head.next;
            size++;
        }

        return size;
    }
}
