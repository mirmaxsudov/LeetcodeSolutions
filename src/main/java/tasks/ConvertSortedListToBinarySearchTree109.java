package tasks;

import java.util.ArrayList;
import java.util.List;

public class ConvertSortedListToBinarySearchTree109 {
    public static void main(String[] args) {

    }

    private TreeNode res;

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return res;

        List<Integer> list = new ArrayList<>();
        read(list, head);
        res = insert(list, 0, list.size() - 1);
        return res;
    }

    private TreeNode insert(List<Integer> list, int left, int right) {
        if (left > right)
            return null;

        int mid = left + (right - left) / 2;

        TreeNode root = new TreeNode(list.get(mid));
        root.left = insert(list, left, mid - 1);
        root.right = insert(list, mid + 1, right);
        return root;
    }

    private void read(List<Integer> list, ListNode head) {
        if (head == null)
            return;

        list.add(head.val);
        read(list, head.next);
    }
}