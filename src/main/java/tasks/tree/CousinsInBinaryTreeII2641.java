package tasks.tree;

import tasks.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CousinsInBinaryTreeII2641 {
    public static void main(String[] args) {
    }

    public static TreeNode replaceValueInTree(TreeNode root) {
        dfs(List.of(root));
        return root;
    }

    private static void dfs(List<TreeNode> nodes) {
        List<Map<TreeNode, List<TreeNode>>> list = new ArrayList<>();
    }
}