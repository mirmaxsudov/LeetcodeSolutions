package tasks;

public class FlattenAMultilevelDoublyLinkedList430 {
    public static void main(String[] args) {

    }

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    private Node res = new Node();

    public Node flatten(Node head) {
        readAndInsert(head);
        return res;
    }

    private void readAndInsert(Node head) {
        if (head == null)
            return;

        res = new Node();
        res.val = head.val;
        res = res.next;

        if (head.child != null) {
            readAndInsert(head.child);
        }

        readAndInsert(head.next);
    }
}