package tasks;

public class SplitLinkedListInParts725 {
    public static void main(String[] args) {

    }

    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] res = new ListNode[k];
        int size = getSize(head);

        if (k >= size) {
            int index = 0;
            while (head != null) {
                res[index] = new ListNode(head.val);
                head = head.next;
            }

            return res;
        }

        ListNode temp = new ListNode(-1);
        ListNode helper = temp;

        for (int i = 0; i < size / k; i++) {
            
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
