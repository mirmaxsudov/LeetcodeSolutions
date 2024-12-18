package univer_lesson.binarySearchTree;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class MyTreeList {
    private MyNode root;
    private int size;

    public MyTreeList() {
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

        // Find the node to delete
        while (current != null && current.data != data) {
            parent = current;
            if (data < current.data) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        // If the node is not found
        if (current == null) {
            return false;
        }

        // Case 1: Node with no children (leaf node)
        if (current.left == null && current.right == null) {
            if (current == root) {
                root = null;
            } else if (parent.left == current) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }
        // Case 2: Node with only one child
        else if (current.left == null || current.right == null) {
            MyNode child = (current.left != null) ? current.left : current.right;

            if (current == root) {
                root = child;
            } else if (parent.left == current) {
                parent.left = child;
            } else {
                parent.right = child;
            }
        }
        // Case 3: Node with two children
        else {
            // Find the in-order successor (smallest node in the right subtree)
            MyNode successorParent = current;
            MyNode successor = current.right;

            while (successor.left != null) {
                successorParent = successor;
                successor = successor.left;
            }

            // Replace the current node's value with the successor's value
            current.data = successor.data;

            // Remove the successor node
            if (successorParent.left == successor) {
                successorParent.left = successor.right;
            } else {
                successorParent.right = successor.right;
            }
        }

        size--;
        return true;
    }


    private MyNode findRightMin(MyNode node, int data) {
        if (node == null)
            return null;

        if (node.data < data) {
            return findRightMin(node.right, data);
        } else {
            return findRightMin(node.left, data);
        }
    }

    private MyNode findLeftMax(MyNode node, int data) {
        if (node == null)
            return null;

        if (node.data > data) {
            return findLeftMax(node.left, data);
        } else {
            return findLeftMax(node.right, data);
        }
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

    private MyNode findMin(MyNode node) {
        while (node.left != null)
            node = node.left;

        return node;
    }

    public int findSize() {
        MyNode temp = this.root;
        return findSize(temp);
    }

    private int findSize(MyNode node) {
        if (node == null)
            return 0;

        return 1 + findSize(node.left) + findSize(node.right);
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