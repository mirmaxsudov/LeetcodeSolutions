package tasks;

import java.util.*;

public class CreateBinaryTreeFromDescriptions2196 {
    public static void main(String[] args) {
        int[][] descriptions = {
                {1, 2, 1},
                {1, 3, 0},
                {2, 4, 1}
        };

        var obj = new CreateBinaryTreeFromDescriptions2196();
        TreeNode binaryTree = obj.createBinaryTree(descriptions);

        inOrder(binaryTree);
    }

    private static void inOrder(TreeNode binaryTree) {
        if (binaryTree == null)
            return;

        inOrder(binaryTree.left);
        System.out.print(binaryTree.val + ", ");
        inOrder(binaryTree.right);
    }

    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> nodeMap = new HashMap<>();
        Set<Integer> children = new HashSet<>();

        for (int[] description : descriptions) {
            int parentVal = description[0];
            int childVal = description[1];
            int isLeft = description[2];

            TreeNode parent = nodeMap.computeIfAbsent(parentVal, k -> new TreeNode(parentVal));
            TreeNode child = nodeMap.computeIfAbsent(childVal, k -> new TreeNode(childVal));

            children.add(childVal);

            if (isLeft == 1) {
                parent.left = child;
            } else {
                parent.right = child;
            }
        }

        int rootVal = -1;
        for (int[] description : descriptions) {
            if (!children.contains(description[0])) {
                rootVal = description[0];
                break;
            }
        }

        return nodeMap.get(rootVal);
    }
}