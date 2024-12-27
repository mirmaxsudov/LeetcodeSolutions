package univer_lesson.binarySearchTree;

import lombok.Getter;

import java.util.*;

@Getter
public class MyTreeList {
    private MyNode root;
    private int size;

    public MyTreeList() {
    }

    public void levelOrderWithIterative() {
        if (root == null)
            return;

        List<MyNode> nodes = new ArrayList<>();

        MyNode temp = root;
        nodes.add(temp);

        while (!nodes.isEmpty()) {
            List<MyNode> helpers = new ArrayList<>();

            for (MyNode node : nodes) {
                if (node.left != null)
                    helpers.add(node.left);

                if (node.right != null)
                    helpers.add(node.right);
            }

            System.out.print(" ".repeat(helpers.size()));

            for (MyNode node : nodes)
                System.out.print(node.data + " | ");

            System.out.println();
            nodes = helpers;
        }
    }

    public void inOrderWithIterative() {
        MyNode cr = this.root;
        Stack<MyNode> stack = new Stack<>();

        while (cr != null || !stack.isEmpty()) {
            while (cr != null) {
                stack.push(cr);
                cr = cr.left;
            }

            cr = stack.pop();
            System.out.print(cr.data + " | ");
            cr = cr.right;
        }
    }

    public void postOrder() {
    }

    public int size() {
        return this.size;
    }

    public void delete(int data) {
        this.root = delete(root, data);
    }

    public boolean deleteWithIterativeWay(int data) {
        if (root == null)
            return false;

        MyNode parent = null;
        MyNode current = root;

        while (current != null && current.data != data) {
            parent = current;
            if (data < current.data) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        if (current == null)
            return false;

        if (current.left == null && current.right == null) {
            if (current == root) {
                root = null;
            } else if (parent.left == current) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        } else if (current.left == null || current.right == null) {
            MyNode child = (current.left != null) ? current.left : current.right;

            if (current == root) {
                root = child;
            } else if (parent.left == current) {
                parent.left = child;
            } else {
                parent.right = child;
            }
        } else {
            MyNode successorParent = current;
            MyNode successor = current.right;

            while (successor.left != null) {
                successorParent = successor;
                successor = successor.left;
            }

            current.data = successor.data;

            if (successorParent.left == successor) {
                successorParent.left = successor.right;
            } else {
                successorParent.right = successor.right;
            }
        }

        size--;
        return true;
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

        MyNode current = root;

        while (true) {
            if (value < current.data) {
                if (current.left == null) {
                    current.left = new MyNode(value);
                    size++;
                    return;
                }
                current = current.left;
            } else if (value > current.data) { // Avoid duplicates
                if (current.right == null) {
                    current.right = new MyNode(value);
                    size++;
                    return;
                }
                current = current.right;
            } else {
                return;
            }
        }
    }

    private MyNode findMin(MyNode node) {
        while (node.left != null)
            node = node.left;

        return node;
    }

    public int findSize() {
        MyNode temp = this.root;
        return findSize(temp);
    }

    public int findSize(MyNode node) {
        if (node == null)
            return 0;

        return findSize(node.left) + 1 + findSize(node.right);
    }

    public void inOrderPrint() {
        inOrderPrint(this.root);
        System.out.println();
    }

    private void inOrderPrint(MyNode root) {
        if (root == null)
            return;

        inOrderPrint(root.left);
        System.out.print(root.data + " | ");
        inOrderPrint(root.right);
    }

    public void preOrderPrint() {
        preOrderPrint(this.root);
        System.out.println();
    }

    private void preOrderPrint(MyNode root) {
        if (root == null)
            return;

        System.out.print(root.data + " | ");
        preOrderPrint(root.left);
        preOrderPrint(root.right);
    }

    public void postOrderPrint() {
        postOrderPrint(this.root);
        System.out.println();
    }

    private void postOrderPrint(MyNode root) {
        if (root == null)
            return;

        postOrderPrint(root.left);
        postOrderPrint(root.right);
        System.out.print(root.data + " | ");
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