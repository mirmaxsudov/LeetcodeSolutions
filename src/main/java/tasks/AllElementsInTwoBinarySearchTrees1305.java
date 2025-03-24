package tasks;

import java.util.ArrayList;
import java.util.List;

public class AllElementsInTwoBinarySearchTrees1305 {
    public static void main(String[] args) {

    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> res = new ArrayList<>();

        read(root1, list1);
        read(root2, list2);

        int i1 = 0;
        int i2 = 0;

        while (list1.size() > i1 && list2.size() > i2) {
            if (list1.get(i1) < list2.get(i2))
                res.add(list1.get(i1++));
            else
                res.add(list2.get(i2++));
        }

        while (list1.size() > i1)
            res.add(list1.get(i1++));

        while (list2.size() > i2)
            res.add(list2.get(i2++));

        return res;
    }

    private void read(TreeNode root, List<Integer> list) {
        if (root == null)
            return;

        read(root.left, list);
        list.add(root.val);
        read(root.right, list);
    }
}