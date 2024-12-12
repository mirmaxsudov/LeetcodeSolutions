package univer_lesson.binarySearchTree;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class MyTreeList {
    private MyNode root;
    private int size;

    public MyTreeList(int data) {
        root = new MyNode(data);
        this.size++;
    }

    public MyTreeList() {
    }

    public int size() {
        return this.size;
    }

    public void delete(int data) {
        this.root = delete(root, data);
    }

    private MyNode delete(MyNode root, int data) {
        if (root == null)
            return null;

        if (data > root.data) {
            root.right = delete(root.right, data);
        } else if (data < root.data) {
            root.left = delete(root.left, data);
        } else {
            if (root.left == null) {
                this.size--;
                return root.right;
            } else if (root.right == null) {
                this.size--;
                return root.left;
            } else {
                MyNode minNode = findMin(root.right);
                root.data = minNode.data;
                root.right = delete(root.right, minNode.data);
            }
        }
        return root;
    }

    public void insert(int value) {
        if (root == null) {
            root = new MyNode(value);
            size++;
            return;
        }

        MyNode node = root;
        while (true) {
            if (value < node.data) {
                if (node.left == null) {
                    node.left = new MyNode(value);
                    size++;
                    return;
                }
                node = node.left;
            } else {
                if (node.right == null) {
                    node.right = new MyNode(value);
                    size++;
                    return;
                }
                node = node.right;
            }
        }
    }

    public MyNode findMin(MyNode node) {
        while (node.left != null)
            node = node.left;

        return node;
    }

    @Override
    public String toString() {
        List<Integer> list = new ArrayList<>();
        inOrder(list, root);
        return list.toString();
    }

    private void inOrder(List<Integer> list, MyNode root) {
        if (root == null)
            return;

        inOrder(list, root.left);
        list.add(root.data);
        inOrder(list, root.right);
    }
}