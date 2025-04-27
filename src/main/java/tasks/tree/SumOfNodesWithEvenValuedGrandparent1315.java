package tasks.tree;

import tasks.TreeNode;

public class SumOfNodesWithEvenValuedGrandparent1315 {
    public static void main(String[] args) {
        Integer[] data = {
                6,
                7, 8,
                2, 7, 1, 3,
                9, null, 1, 4, null, null, null, 5
        };

        TreeNode treeNode = buildTree(data);

        System.out.println(sumEvenGrandparent(treeNode));
    }

    public static TreeNode buildTree(Integer[] vals) {
        return build(vals, 0);
    }

    private static TreeNode build(Integer[] vals, int i) {
        // if index out of bounds or this position is null, return no node
        if (i >= vals.length || vals[i] == null) {
            return null;
        }
        // otherwise create node and recursively attach children
        TreeNode node = new TreeNode(vals[i]);
        node.left = build(vals, 2 * i + 1);
        node.right = build(vals, 2 * i + 2);
        return node;
    }

    static int sum = 0;

    public static int sumEvenGrandparent(TreeNode root) {
        if (root == null)
            return sum;

        if (root.left != null) {
            dfs(root, root.left.left);
            dfs(root, root.left.right);
        }
        if (root.right != null) {
            dfs(root, root.right.left);
            dfs(root, root.right.right);
        }

        return sum;
    }

    private static void dfs(TreeNode grandParent, TreeNode child) {
        if (child == null)
            return;

        if (grandParent.val % 2 == 0)
            sum += child.val;

        dfs(grandParent.left, child.left);
        dfs(grandParent.left, child.right);
        dfs(grandParent.right, child.left);
        dfs(grandParent.right, child.right);
    }
}