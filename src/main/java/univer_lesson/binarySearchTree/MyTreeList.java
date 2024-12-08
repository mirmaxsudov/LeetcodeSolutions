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

    public void insert(int data) {
        if (this.root == null) {
            this.root = new MyNode(data);
            return;
        }

        MyNode temp = this.root;
        insertNode(temp, data);
    }

    private void insertNode(MyNode temp, int data) {
        if (temp == null) {
            temp = new MyNode(data);
            this.size++;
            return;
        }

        if (temp.data == data)
            return;

        if (temp.data > data) {
            insertNode(temp.left, data);
        } else {
            insertNode(temp.right, data);
        }
    }

    public List<Integer> getAll() {
        List<Integer> values = new ArrayList<>();

        MyNode temp = this.root;

        takeAll(values, temp);

        return values;
    }

    private void takeAll(List<Integer> values, MyNode temp) {
        if (temp == null)
            return;

        values.add(temp.data);

        takeAll(values, temp.left);
        takeAll(values, temp.right);
    }
}