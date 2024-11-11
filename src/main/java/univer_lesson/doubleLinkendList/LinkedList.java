package univer_lesson.doubleLinkendList;

import lombok.Getter;

import java.util.StringJoiner;

public class LinkedList {
    Node head;
    @Getter
    int length = 0;

    LinkedList() {
        head = null;
        length = 0;
    }

    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.link != null) {
                temp = temp.link;
            }
            temp.link = newNode;
        }
        length++;
    }

    public void insertBeg(int data) {
        if (head == null) {
            head = new Node(data);
        } else {
            Node newNode = new Node(data);
            newNode.link = head;
            head = newNode;
        }
        length++;
    }

    public void delete(int index) {
        // Check if the index is negative
        if (index < 0) {
            System.out.println("Index could not be negative");
            return;
        }

        // Check if the list is empty
        if (head == null) {
            System.out.println("There is no node");
            return;
        }

        // Initialize a temporary node pointing to the head of the list
        Node temp = head;

        // Traverse the list until the end
        while (temp.link != null) {
            // Decrement index as we move to the next node
            index--;

            // If the current position is right before the target node, adjust the link
            if (index == 1) {
                temp.link = temp.link.link; // Bypass the target node
                return;
            }

            // Move to the next node
            temp = temp.link;
        }
    }


    public void deleteEnd() {
        if (head == null) {
            System.out.println("There is no node");
            return;
        }

        if (head.link == null) {
            head = null;
            length = 0;
            return;
        }

        Node temp = head;

        while (temp.link.link != null)
            temp = temp.link;

        temp.link = null;
        length--;
    }

    public void insertEnd(int data) {

    }

    public void deleteBeg() {
        if (head == null) {
            System.out.println("Empty Linked List");
            return;
        }

        head = head.link;
        length--;
    }

    static class Node {
        int data;
        Node link;

        public Node(int data) {
            this.data = data;
            this.link = null;
        }
    }

    @Override
    public String toString() {
        if (head == null) {
            return "";
        }

        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        Node temp = head;

        while (temp.link != null) {
            joiner.add("" + temp.data);
            temp = temp.link;
        }

        return joiner.toString();
    }
}