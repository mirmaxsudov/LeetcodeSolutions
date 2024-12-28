package tasks;

import java.util.ArrayList;
import java.util.List;

public class NAryTreePostorderTraversal590 {
    public static void main(String[] args) {

    }

    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        read(root, list);
        return list;
    }

    private void read(Node root, List<Integer> list) {
        if (root == null)
            return;

        for (Node child : root.children)
            read(child, list);

        list.add(root.val);
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