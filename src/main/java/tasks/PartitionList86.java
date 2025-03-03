package tasks;

public class PartitionList86 {
    public static void main(String[] args) {
//        int[] arr = {1, 4, 3, 2, 5, 2};
        int[] arr = {2, 1};

        ListNode res = new ListNode(-1);
        ListNode temp = res;

        for (int num : arr) {
            temp.next = new ListNode(num);
            temp = temp.next;
        }

        res = res.next;

        ListNode result = partition(res, 3);

        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

    public static ListNode partition(ListNode head, int x) {
        ListNode res = new ListNode(-1);
        ListNode temp = res;

        ListNode helpToCollectGreater = new ListNode(-1);
        ListNode tempHelp = helpToCollectGreater;

        while (head != null) {
            int val = head.val;

            if (val >= x) {
                tempHelp.next = new ListNode(val);
                tempHelp = tempHelp.next;
            } else {
                temp.next = new ListNode(val);
                temp = temp.next;
            }
            head = head.next;
        }

        temp.next = helpToCollectGreater.next;
        return res.next;
    }
}