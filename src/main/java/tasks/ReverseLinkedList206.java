package tasks;

public class ReverseLinkedList206 {
    public static void main(String[] args) {

    }

    ListNode res;

    public ListNode reverseListVer2(ListNode head) {
        if (head == null)
            return head;

        res = new ListNode(head.val);
        head = head.next;
        dfs(head);
        return res;
    }

    private void dfs(ListNode root) {
        if (root == null)
            return;

        this.res = new ListNode(root.val, this.res);
        dfs(root.next);
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode temp = new ListNode(head.val);
        head = head.next;

        while (head != null) {
            temp = new ListNode(head.val, temp);
            head = head.next;
        }

        return temp;
    }
}