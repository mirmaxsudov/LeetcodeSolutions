package univer_lesson.linked;

public class Main {
    public static void main(String[] args) {
    }

    static class Linked {
        private Node head;

        static class Node {
            int data;
            Node next;

            public Node(int data) {
                this.data = data;
                this.next = null;
            }

            public Node(int data, Node next) {
                this.data = data;
                this.next = next;
            }
        }

        public boolean isExistsCycle() {
            return false;
        }

        public int findMiddleVal() {
            if (head == null)
                return -1;

            Node slow = head;
            Node fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            return slow.data;
        }

        public void reverse() {
//            Node prev = null;
//            Node current = head;
//            Node next = null;
//            while (current != null) {
//                next = current.next;
//                current.next = prev;
//                prev = current;
//                current = next;
//            }
//            head = prev;

            Node prev = null;

            while (head != null) {
                prev = new Node(head.data, prev);
                head = head.next;
            }

            head = prev;
        }

        public boolean delete(int data) {
            if (head == null)
                return false;

            if (head.data == data) {
                head = head.next;
                return true;
            }

            Node temp = head;
            while (temp.next != null) {
                if (temp.next.data == data) {
                    temp.next = temp.next.next;
                    return true;
                } else
                    temp = temp.next;
            }

            return false;
        }

        public void insert(int data) {
            if (head == null) {
                head = new Node(data);
                return;
            }

            Node temp = head;

            while (temp.next != null)
                temp = temp.next;

            temp.next = new Node(data);
        }
    }
}