package univer_lesson.exam;

public class P4 {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(20);
        bst.insert(8);
        bst.insert(22);
        bst.insert(4);
        bst.insert(12);
        bst.insert(10);
        bst.insert(14);

        int k = 3;
        int result = bst.kthSmallest(bst.root, k);
        System.out.println("The " + k + "th smallest element is: " + result);
    }
}

class TreeNode {
    int value;
    TreeNode left, right;

    TreeNode(int value) {
        this.value = value;
        left = right = null;
    }
}

class BinarySearchTree {
    TreeNode root;

    public void insert(int value) {
        root = insertRec(root, value);
    }

    private TreeNode insertRec(TreeNode root, int value) {
        if (root == null) {
            root = new TreeNode(value);
            return root;
        }

        if (value < root.value) {
            root.left = insertRec(root.left, value);
        } else if (value > root.value) {
            root.right = insertRec(root.right, value);
        }

        return root;
    }

    public int kthSmallest(TreeNode root, int k) {
        int[] count = {0};
        return inOrderTraversal(root, k, count);
    }

    private int inOrderTraversal(TreeNode node, int k, int[] count) {
        if (node == null) return -1;

        int left = inOrderTraversal(node.left, k, count);
        if (left != -1) return left;
        count[0]++;
        if (count[0] == k) return node.value;
        return inOrderTraversal(node.right, k, count);
    }
}