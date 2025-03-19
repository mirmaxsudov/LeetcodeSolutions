package tasks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateSubtrees652 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);

        var main = new FindDuplicateSubtrees652();
        main.findDuplicateSubtrees(root);

    }

    private List<TreeNode> res = new ArrayList<>();
    private Map<Integer, List<TreeNode>> mp = new HashMap<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        readAndSet(root);

        System.out.println(mp);

        return res;
    }

    private void readAndSet(TreeNode root) {
        if (root == null)
            return;

        List<TreeNode> list = mp.getOrDefault(root.val, new ArrayList<>());
        list.add(root);
        mp.put(root.val, list);

        readAndSet(root.left);
        readAndSet(root.right);
    }
}