package tasks;


public class Task {
    public static void main(String[] args) {

//                      10     (6)
//                    4   6
//                  2
//                 1
    }
}

class Node {
    int val;
    Node prev;
    Node next;

    public Node(int data) {
        this.val = data;
        this.prev = null;
        this.next = null;
    }
}

class DoubleLinkedList {
    private Node head;
    private Node tail;

    DoubleLinkedList() {
        this.head = null;
        this.tail = null;
    }


    public int size() {
        int size = 0;

        Node temp = this.head;

        while (temp != null) {
            size++;
            temp = temp.next;
        }

        return size;
    }

    public void clear() {
        head = null;
    }

    public void delete() {
        tail = tail.prev;
        tail.next = null;
    }

    public void add(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;
    }

    public String toString() {
        Node temp = this.head;

        StringBuilder sb = new StringBuilder();

        while (temp != null) {
            sb.append(temp.val);
            sb.append(" ");
            temp = temp.next;
        }

        return sb.toString();
    }
}