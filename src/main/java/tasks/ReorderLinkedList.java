package tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ReorderLinkedList {
    public static void main(String[] args) {
        ReorderLinkedList main = new ReorderLinkedList();
        // 2,4,6,8,10
        ListNode head = new ListNode(2, new ListNode(4, new ListNode(6, new ListNode(8, new ListNode(10)))));
        main.reorderList(head);

        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
    }

    public void reorderList(ListNode head) {
        List<Integer> list = new ArrayList<>();

        ListNode temp = head;

        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }


        int iCount = list.size() / 2;
        int fI = 0, lI = list.size() - 1;

        temp = head;

        while (iCount-- != 0) {
            temp.val = list.get(fI++);
            temp = temp.next;
            temp.val = list.get(lI--);
            temp = temp.next;
        }

        if ((list.size() & 1) == 1) temp.val = list.get(fI);
    }
}

// [0, n-1, 1, n-2, 2, n-3, ...]
// [2,4,6,8]
// [2,8,4,6]