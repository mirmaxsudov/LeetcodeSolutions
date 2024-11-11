package univer_lesson.doubleLinkendList;

public class Example {
    public static void main(String[] args) {

    }
}

class Node {
    int data;
    Node next;
    Node prev;

    public Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class DoubleLinkedList {
    Node head;
    Node tail;

    public DoubleLinkedList() {
        this.head = null;
        this.tail = null;
    }
}