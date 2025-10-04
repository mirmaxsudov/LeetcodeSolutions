package tasks.tree;

import tasks.TreeNode;

import java.util.ArrayList;
import java.util.List;


public class PathInZigzagLabelledBinaryTree1104 {
    public static void main(String[] args) {
        PathInZigzagLabelledBinaryTree1104 main = new PathInZigzagLabelledBinaryTree1104();
        System.out.println(main.pathInZigZagTree(31));
    }

    TreeNode root = null;
    List<Integer> path = new ArrayList<>();

    public List<Integer> pathInZigZagTree(int label) {
        buildTree(label);
        // Find path to labeled node.
        showLevelOrder();
        return path;
    }

    private void showLevelOrder() {
        List<TreeNode> nodes = new ArrayList<>(List.of(root));

        while (!nodes.isEmpty()) {
            List<TreeNode> list = new ArrayList<>();

            for (TreeNode node : nodes) {
                System.out.print(node.val + " - ");
                if (node.left != null)
                    list.add(node.left);
                if (node.right != null)
                    list.add(node.right);
            }

            System.out.println();
            nodes = list;
        }
    }

    private void buildTree(int label) {
        boolean isRight = true;
        int currentLabel = 1;

        List<TreeNode> canSetNodes = new ArrayList<>();
        List<TreeNode> canSetNewNodes = new ArrayList<>();

        while (true) {
            TreeNode newNode = new TreeNode(currentLabel);

            if (currentLabel - 1 == label)
                break;

            // We will set to root because root is null, which means this is first node.
            if (root == null) {
                root = newNode;
                canSetNodes.add(root);
                isRight = false;
            } else {
                // We will iterate from right to left.
                boolean isSet = false;
                if (!isRight) {
                    for (int i = canSetNodes.size() - 1; i >= 0; i--) {
                        TreeNode node = canSetNodes.get(i);

                        if (node.left != null && node.right != null)
                            continue;

                        if (node.right == null) {
                            node.right = newNode;
                        } else {
                            node.left = newNode;
                            canSetNewNodes.addFirst(node.right);
                            canSetNewNodes.addFirst(node.left);

                            if (isFinished(canSetNodes, false)) {
                                canSetNodes = new ArrayList<>(canSetNewNodes);
                                canSetNewNodes.clear();
                            }
                        }
                        isSet = true;
                        break;
                    }

                    // If it has not been set, we will change direction to opposite one.
                    if (!isSet) {
                        isRight = true;
                    }
                } else {
                    // If it is left to right
                    for (TreeNode node : canSetNodes) {
                        if (node.left != null && node.right != null)
                            continue;

                        if (node.left == null) {
                            node.left = newNode;
                        } else {
                            node.right = newNode;
                            canSetNewNodes.addLast(node.left);
                            canSetNewNodes.addLast(node.right);

                            if (isFinished(canSetNodes, true)) {
                                canSetNodes = new ArrayList<>(canSetNewNodes);
                                canSetNewNodes.clear();
                            }
                        }
                        isSet = true;
                        break;
                    }

                    if (!isSet)
                        isRight = false;
                }
            }

            currentLabel++;
        }
    }

    private boolean isFinished(List<TreeNode> canSetNodes, boolean isRight) {
        TreeNode node;
        if (isRight)
            node = canSetNodes.getLast();
        else
            node = canSetNodes.getFirst();

        return node.left != null && node.right != null;
    }
}