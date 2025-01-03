package tasks;

import java.util.List;

public class MaximumDepthOfNAryTree559 {
    public static void main(String[] args) {

    }

    public int maxDepth(Node root) {
        if (root == null)
            return 0;

        int max = 0;

        for (Node child : root.children)
            max = Math.max(max, maxDepth(child));

        return max;
    }

    class Node {
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

    ;
}