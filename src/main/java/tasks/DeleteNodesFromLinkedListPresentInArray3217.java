package tasks;

import java.util.HashMap;
import java.util.Map;

public class DeleteNodesFromLinkedListPresentInArray3217 {
    public static void main(String[] args) {

    }

    public ListNode modifiedList(int[] nums, ListNode head) {
        if (head == null)
            return null;

        ListNode res = new ListNode(-1);
        ListNode temp = res;

        Map<Integer, Boolean> mp = new HashMap<>();

        for (int num : nums)
            mp.put(num, true);

        while (head.next != null) {
            if (mp.get(head.val) != null) {
                temp.next = new ListNode(head.val, null);
                temp = temp.next;
            }

            head = head.next;
        }

        return res.next;
    }
}
