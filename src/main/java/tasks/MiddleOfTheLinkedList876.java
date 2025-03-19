package tasks;

public class MiddleOfTheLinkedList876 {
    public static void main(String[] args) {

    }

    public ListNode middleNode(ListNode head) {
        ListNode f = head;
        ListNode s = head.next.next;

        while (f != null && s != null) {
            f = f.next;
            s = s.next.next;
        }

        return f;
    }
}