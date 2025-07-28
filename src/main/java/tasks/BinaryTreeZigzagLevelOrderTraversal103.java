package tasks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BinaryTreeZigzagLevelOrderTraversal103 {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        var isRight = true;

        while (!nodes.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            if (isRight)
                for (TreeNode node : nodes)
                    list.add(node.val);
            else
                for (int i = nodes.size() - 1; i >= 0; i--)
                    list.add(nodes.get(i).val);

            res.add(list);
            isRight = !isRight;

            List<TreeNode> newNodes = new ArrayList<>();

            int len = nodes.size();

            for (TreeNode node : nodes) {
                if (node.left != null)
                    newNodes.add(node.left);
                if (node.right != null)
                    newNodes.add(node.right);
            }

            nodes.clear();
            nodes = newNodes;
        }

        return res;
    }
}