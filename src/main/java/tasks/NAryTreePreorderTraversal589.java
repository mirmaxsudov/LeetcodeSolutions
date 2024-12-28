package tasks;

import java.util.ArrayList;
import java.util.List;

public class NAryTreePreorderTraversal589 {
    public static void main(String[] args) {

    }

    List<Integer> list = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        read(root);
        return list;
    }

    private void read(Node root) {
        if (root == null)
            return;

        list.add(root.val);

        for (Node child : root.children)
            read(child);
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
