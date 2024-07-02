package tasks;

import java.util.List;
import java.util.concurrent.CompletableFuture;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class SwapNodes {
    public static void main(String[] args) {
        for (int i = 0; i < 100000; i++) {
            for (int i1 = 0; i1 < 1000000; i1++) {

            }
        }
    }

    public ListNode swapNodes(ListNode head, int k) {
        ListNode frs = head;

        for (int i = 0; i < k - 1; i++)
            frs = frs.next;

        int fVal = frs.val;

        int len = getLength(head, 0);

        ListNode sec = frs;

        for (int i = len; i > k; i--) {
            sec = sec.next;
        }

        int sVal = sec.val;
        sec.val = fVal;
        frs.val = sVal;

        return head;
    }

    private int getLength(ListNode init, int size) {
        if (init == null) {
            System.out.println(size);
            return size;
        }

        System.out.println("\t" + size);
        return getLength(init.next, size + 1);
    }
}