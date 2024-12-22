package tasks;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal144 {
    public static void main(String[] args) {

    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        preOrder(root, list);

        return list;
    }

    private static void preOrder(TreeNode root, List<Integer> list) {
        if (root == null)
            return;

        list.add(root.val);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }
}