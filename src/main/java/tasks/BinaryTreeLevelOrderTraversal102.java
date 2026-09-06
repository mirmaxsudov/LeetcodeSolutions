package tasks;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal102 {
    public static void main(String[] args) {

    }

    class Solution {
        List<List<Integer>> r;

        public List<List<Integer>> levelOrder(TreeNode root) {
            r = new ArrayList<>();

            int l = 0, cl = 0;

            Queue<Object[]> q = new LinkedList<>();

            q.add(new Object[]{l++, root});

            List<Integer> currentLevel = new ArrayList<>();

            while (!q.isEmpty()) {
                Object[] polled = q.poll();
                int polledIndex = (int) polled[0];
                TreeNode tree = (TreeNode) polled[1];

                if (tree == null)
                    continue;

                if (cl == polledIndex) {
                    currentLevel.add(tree.val);
                } else {
                    r.add(currentLevel);
                    currentLevel = new ArrayList<>();
                    cl = polledIndex;
                    l++;
                    currentLevel.add(tree.val);
                }

                if (tree.left != null)
                    q.add(new Object[]{l, tree.left});

                if (tree.right != null)
                    q.add(new Object[]{l, tree.right});
            }

            return r;
        }
    }
}

