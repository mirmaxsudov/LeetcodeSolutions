package univer_lesson.binarySearchTree;

import lombok.Getter;

@Getter
public class MyTreeList {
    private MyNode root;
    private int size;

    public MyTreeList(int data) {
        root = new MyNode(data);
    }

    public void insert(int data) {
        if (this.root == null) {
            this.root = new MyNode(data);
            return;
        }
    }
}