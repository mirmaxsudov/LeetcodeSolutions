package tasks;

public class MergeKSortedLinkedLists {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(2));
        ListNode list2 = new ListNode(1, new ListNode(3));

        MergeKSortedLinkedLists main = new MergeKSortedLinkedLists();
        ListNode merged = main.merge(list1, list2);

        while (merged != null) {
            System.out.println(merged.val);
            merged = merged.next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;

        ListNode res = null;

        for (ListNode list : lists) res = merge(res, list);

        return res;
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;

        ListNode temp1 = head1, temp2 = head2;
        ListNode result = new ListNode(Integer.MIN_VALUE);
        ListNode tempResult = result;

        while (temp1 != null && temp2 != null) {
            if (temp1.val > temp2.val) {
                tempResult.next = new ListNode(temp2.val);
                temp2 = temp2.next;
            } else {
                tempResult.next = new ListNode(temp1.val);
                temp1 = temp1.next;
            }
            tempResult = tempResult.next;
        }

        if (temp1 != null) tempResult.next = temp1;
        if (temp2 != null) tempResult.next = temp2;

        return result.next;
    }
}
