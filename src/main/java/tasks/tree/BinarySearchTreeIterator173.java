package tasks.tree;

import tasks.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTreeIterator173 {
    public static void main(String[] args) {

    }

    class BSTIterator {
        private final List<Integer> list;
        private int crtIndex = 0;

        public BSTIterator(TreeNode root) {
            list = new ArrayList<>();
            read(root);
        }

        private void read(TreeNode root) {
            if (root == null)
                return;

            read(root.left);
            list.add(root.val);
            read(root.right);
        }

        public int next() {
            if (crtIndex == list.size())
                return -1;

            return list.get(crtIndex++);
        }

        public boolean hasNext() {
            return crtIndex != list.size();
        }
    }
}