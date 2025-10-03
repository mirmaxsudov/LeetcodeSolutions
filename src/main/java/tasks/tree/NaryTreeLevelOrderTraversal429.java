package tasks.tree;

import java.util.*;

public class NaryTreeLevelOrderTraversal429 {
    public static void main(String[] args) {
        NaryTreeLevelOrderTraversal429 main = new NaryTreeLevelOrderTraversal429();
        System.out.println(main.levelOrderWithBFS(new Node(
                1,
                List.of(
                        new Node(3,
                                List.of(
                                        new Node(5),
                                        new Node(6)
                                )),
                        new Node(2),
                        new Node(4)
                )
        )));
    }

    public List<List<Integer>> levelOrderWithBFS(Node root) {
        List<List<Integer>> res = new ArrayList<>();

        Queue<Helper> q = new LinkedList<>();
        q.offer(new Helper(root, 0));

        List<Integer> list = new ArrayList<>();

        while (!q.isEmpty()) {
            Helper helper = q.poll();

            if (helper.node.children != null)
                for (Node child : helper.node.children)
                    q.offer(new Helper(child, helper.level + 1));

            if (helper.level == res.size()) {
                list.add(helper.node.val);
            } else {
                res.add(new ArrayList<>(list));
                list.clear();
                list.add(helper.node.val);
            }
        }

        if (!list.isEmpty())
            res.add(list);

        return res;
    }

    class Helper {
        Node node;
        int level;

        public Helper(Node node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    Map<Integer, List<Integer>> mp = new HashMap<>();

    public List<List<Integer>> levelOrder(Node root) {

        dfs(root, 0);

        List<Integer>[] array = new List[mp.size()];

        for (Map.Entry<Integer, List<Integer>> e : mp.entrySet())
            array[e.getKey()] = e.getValue();

        return new ArrayList<>(Arrays.asList(array));
    }

    private void dfs(Node root, int level) {
        if (root == null)
            return;

        mp.putIfAbsent(level, new ArrayList<>());
        mp.get(level).add(root.val);

        for (Node child : root.children)
            dfs(child, level + 1);
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
