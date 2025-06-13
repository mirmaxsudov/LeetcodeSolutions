package tasks;

import java.util.ArrayList;
import java.util.List;

public class RecoverBinarySearchTree99 {
    public static void main(String[] args) {

    }

    public void recoverTree(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        read(root, list);

        TreeNode first = null, second = null;

        for (int i = 1; i < list.size(); i++) {

        }
    }

    public void read(TreeNode root, List<Integer> list) {
        if (root == null)
            return;

        read(root.left, list);
        list.add(root.val);
        read(root.right, list);
    }
}