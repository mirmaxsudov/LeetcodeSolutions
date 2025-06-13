package tasks;

import java.util.LinkedList;
import java.util.Queue;

public class DeleteNodeInABST450 {
    public static void main(String[] args) {

    }

    public void deletDeepest(TreeNode root, TreeNode dTreeNode) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        TreeNode curr;
        while (!q.isEmpty()) {
            curr = q.poll();
            if (curr == dTreeNode) {
                curr = null;
                dTreeNode = null;
                return;
            }

            if (curr.right != null) {
                if (curr.right == dTreeNode) {
                    curr.right = null;
                    dTreeNode = null;
                    return;
                }
                q.add(curr.right);
            }

            // Check the left child
            if (curr.left != null) {
                if (curr.left == dTreeNode) {
                    curr.left = null;
                    dTreeNode = null;
                    return;
                }
                q.add(curr.left);
            }
        }
    }

    public TreeNode deleteTreeNode(TreeNode root, int key) {
        if (root == null)
            return null;

        if (root.left == null && root.right == null) {
            if (root.val == key)
                return null;
            else
                return root;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        TreeNode curr = null;
        TreeNode keyNode = null;

        while (!q.isEmpty()) {
            curr = q.poll();

            if (curr.val == key)
                keyNode = curr;

            if (curr.left != null)
                q.add(curr.left);

            if (curr.right != null)
                q.add(curr.right);
        }

        if (keyNode != null) {
            keyNode.val = curr.val;
            deletDeepest(root, curr);
        }
        return root;
    }
}
