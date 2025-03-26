package tasks;

public class MergeNodesInBetweenZeros2181 {
    public static void main(String[] args) {

    }

    public ListNode mergeNodes(ListNode head) {
        ListNode res = new ListNode(-1);
        ListNode temp = res;

        int sum = 0;

        head = head.next;

        while (head != null) {
            if (head.val == 0) {
                temp.next = new ListNode(sum);
                temp = temp.next;
                sum = 0;
            } else
                sum += head.val;

            head = head.next;
        }

        return res.next;
    }
}