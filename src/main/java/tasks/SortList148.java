package tasks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortList148 {
    public static void main(String[] args) {

    }

    public static ListNode sortList(ListNode head) {
        List<Integer> list = new ArrayList<>();

        read(head, list);
        Collections.sort(list);

        ListNode res = new ListNode(-1);
        ListNode temp = res;

        for (int num : list) {
            temp.next = new ListNode(num);
            temp = temp.next;
        }

        return res.next;
    }

    private static void read(ListNode node, List<Integer> list) {
        if (node == null)
            return;

        list.add(node.val);
        read(node.next, list);
    }
}
