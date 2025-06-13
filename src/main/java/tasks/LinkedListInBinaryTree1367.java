package tasks;

public class LinkedListInBinaryTree1367 {
    public static void main(String[] args) {

    }

    public boolean isSubPath(ListNode head, TreeNode root) {
        if (head == null || root == null)
            return false;

        if (dfs(head, root))
            return true;

        return isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private boolean dfs(ListNode head, TreeNode root) {
        if (head == null)
            return true;
        if (root == null)
            return false;
        if (head.val == root.val)
            return dfs(head.next, root.left) || dfs(head.next, root.right);
        else
            return false;
    }
}