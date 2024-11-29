package tasks;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class SwapNodesInPairs24 {
    public static void main(String[] args) {

    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;

        List<Integer> list = new ArrayList<>();

        read(head, list);
        swap(list);

        ListNode res = new ListNode(-1, null);

        for (Integer num : list) {
            res.next = new ListNode(num, null);
            res = res.next;
        }

        return res.next;
    }

    private void swap(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i += 2) {
            list.set(i, list.get(i) + list.get(i + 1));
            list.set(i + 1, list.get(i) - list.get(i + 1));
            list.set(i, list.get(i) - list.get(i + 1));
        }
    }

    private void read(ListNode root, List<Integer> list) {
        if (root == null)
            return;

        read(root.next, list);
        list.add(root.val);
    }
}