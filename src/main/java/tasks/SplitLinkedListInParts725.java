package tasks;

public class SplitLinkedListInParts725 {
    public static void main(String[] args) {

    }

    public ListNode[] splitListToParts(ListNode head, int k) {
        int size = getSize(head);
        ListNode[] res = new ListNode[k];

        if (size < k) {
            for (int i = 0; i < size; i++) {
                res[i] = new ListNode(head.val);
                head = head.next;
            }
        }

        return res;
    }

    private int getSize(ListNode head) {
        int size = 0;
        while (head != null) {
            head = head.next;
            size++;
        }
        return size;
    }
}
