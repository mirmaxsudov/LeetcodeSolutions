package tasks;

public class FlattenAMultilevelDoublyLinkedList430 {
    public static void main(String[] args) {
        var main = new FlattenAMultilevelDoublyLinkedList430();
        Node flatten = main.flatten(main.buildTestList());

        while (flatten.next != null) {
            System.out.print(flatten.val + " ");
            flatten = flatten.next;
        }


        System.out.println();
        System.out.println();

        while (flatten != null) {
            System.out.print(flatten.val + " ");
            flatten = flatten.prev;
        }
    }

    public Node buildTestList() {
        // Create all nodes
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        Node n9 = new Node(9);
        Node n10 = new Node(10);
        Node n11 = new Node(11);
        Node n12 = new Node(12);

        // Link the top level: 1 <-> 2 <-> 3 <-> 4 <-> 5 <-> 6
        n1.next = n2;
        n2.prev = n1;
        n2.next = n3;
        n3.prev = n2;
        n3.next = n4;
        n4.prev = n3;
        n4.next = n5;
        n5.prev = n4;
        n5.next = n6;
        n6.prev = n5;

        // Set the child pointer for node 3 → node 7
        n3.child = n7;

        // Link the second level: 7 <-> 8 <-> 9 <-> 10
        n7.next = n8;
        n8.prev = n7;
        n8.next = n9;
        n9.prev = n8;
        n9.next = n10;
        n10.prev = n9;

        // Set the child pointer for node 8 → node 11
        n8.child = n11;

        // Link the third level: 11 <-> 12
        n11.next = n12;
        n12.prev = n11;

        // Return the head of the entire structure
        return n1;
    }

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }
    }

    private Node res = new Node();
    private Node current;

    public Node flatten(Node head) {
        res.next = null;
        res.prev = null;
        res.child = null;

        current = res;

        while (head != null) {
            Node next = new Node();

            next.val = head.val;
            current.next = next;
            next.prev = current;
            next.child = null;
            current = current.next;

            if (head.child != null)
                readValues(head.child);

            head = head.next;
        }

        if (res == null || res.next == null)
            return null;

        res = res.next;
        res.prev = null;
        return res;
    }

    private void readValues(Node child) {
        if (child == null)
            return;

        Node next = new Node();

        next.val = child.val;
        next.child = null;
        current.next = next;
        next.prev = current;
        current = current.next;

        if (child.child != null)
            readValues(child.child);

        if (child.next != null)
            readValues(child.next);
    }
}