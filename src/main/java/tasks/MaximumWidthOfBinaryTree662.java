package tasks;

import java.util.ArrayList;
import java.util.List;

public class MaximumWidthOfBinaryTree662 {
    public static void main(String[] args) {

    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;

        int max = 0;

        List<TreeNode> children = new ArrayList<>();
        children.add(root);

        int prev = 1, sPrev = 2, level = 1;

        while (!children.isEmpty()) {
            if (level == 1)
                max = 1;
            else if (level == 2)
                max = children.size();


            int theMostLeftNodeIndex = getTheMostLeftNode(children);
            int theMostRightNodeIndex = getTheMostRightNode(children);

            if (theMostLeftNodeIndex != theMostRightNodeIndex)
                max = Math.max(max, theMostRightNodeIndex - theMostLeftNodeIndex + 1);

            // We will take a max width of level tree
            int temp = prev + sPrev;
            prev = sPrev;
            sPrev = temp;

            List<TreeNode> nextLevel = new ArrayList<>();

            for (TreeNode child : children) {
                if (child.left != null)
                    nextLevel.add(child.left);
                if (child.right != null)
                    nextLevel.add(child.right);
            }

            children = nextLevel;

            level++;
        }

        return max;
    }

    private int getTheMostRightNode(List<TreeNode> children) {
        for (int i = children.size() - 1; i >= 0; i--)
            if (children.get(i) != null)
                return i;
        return -1;
    }

    private int getTheMostLeftNode(List<TreeNode> children) {
        for (int i = 0; i < children.size(); i++)
            if (children.get(i) != null)
                return i;
        return -1;
    }
}