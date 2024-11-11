package univer_lesson.sortedLinkedList;

import java.util.StringJoiner;

public class MySortedLinkedList {
    Node start;
    int size = 0;

    public MySortedLinkedList() {
        this.start = null;
    }

    public void insert(int data) {
        if (start == null) {
            start = new Node(data);
            size++;
            return;
        }

        Node f, t;
        f = t = start;

        while (t != null) {
            if (data < t.data) {
                Node nn = new Node(data);
                nn.next = f;
                start = nn;
                size++;
                return;
            } else {
                f = t;
                t = t.next;
            }
        }

        f.next = new Node(data);
        size++;
    }


    public void delete() {
        if (start == null)
            return;

        start = start.next;
    }

    public int deleteVal(int data) {
        return -1;
    }

    public void delete(int index) {
        if (index < 0) {
            System.out.println("Index could not be negative");
            return;
        }

        if (start == null) {
            System.out.println("There is no node");
            return;
        }

        Node temp = start;

        while (temp.next != null) {
            index--;

            if (index == 1) {
                temp.next = temp.next.next;
                return;
            }

            temp = temp.next;
        }
    }

    @Override
    public String toString() {
        if (start == null) {
            return "[]";
        }

        StringJoiner joiner = new StringJoiner(", ", "[", "]");

        Node temp = start;

        while (temp != null) {
            joiner.add(temp.data + "");
            temp = temp.next;
        }

        return joiner.toString();
    }

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
}