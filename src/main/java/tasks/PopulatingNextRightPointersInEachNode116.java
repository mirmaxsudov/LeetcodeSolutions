package tasks;

import java.util.ArrayList;
import java.util.List;

public class PopulatingNextRightPointersInEachNode116 {
    public static void main(String[] args) {

    }

    public Node connect(Node root) {
        List<Node> list = new ArrayList<>();

        list.add(root);

        while (!list.isEmpty()) {
            List<Node> helper = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                Node node = list.get(i);

                if (node == null)
                    continue;

                if (i < list.size() - 1)
                    node.next = list.get(i + 1);

                if (node.left != null)
                    helper.add(node.left);
                if (node.right != null)
                    helper.add(node.right);
            }

            list = helper;
        }

        return root;
    }

    public Node connectVer2(Node root) {


        return root;
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    ;
}