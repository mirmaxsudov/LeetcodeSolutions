package tasks;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal145 {
    public static void main(String[] args) {

    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postOrder(root, list);
        return list;
    }

    private static void postOrder(TreeNode root, List<Integer> list) {
        if (root == null)
            return;

        postOrder(root.left, list);
        postOrder(root.right, list);

        list.add(root.val);
    }
}