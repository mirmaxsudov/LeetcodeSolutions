package tasks;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SecondMinimumNodeInABinaryTree671 {
    public static void main(String[] args) {
        System.out.println(findSecondMinimumValue(new TreeNode(2, new TreeNode(2), new TreeNode(5, new TreeNode(5), new TreeNode(7)))));
    }

    private static void read(TreeNode root, Set<Integer> st) {
        if (root == null)
            return;

        st.add(root.val);

        read(root.left, st);
        read(root.right, st);
    }

    public static int findSecondMinimumValue(TreeNode root) {
        Set<Integer> st = new TreeSet<>();
        read(root, st);

        if (st.isEmpty() || st.size() < 2)
            return -1;

        return st.stream().skip(1).findFirst().get();
    }
}