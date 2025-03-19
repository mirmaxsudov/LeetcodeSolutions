package tasks;

public class DesignHashSet705 {
    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();

        myHashSet.add(1);
        myHashSet.add(2);

        myHashSet.show();

        myHashSet.remove(1);

        myHashSet.show();
    }

    static class MyHashSet {
        class ListNode {
            int val;
            ListNode next;

            ListNode() {
            }

            ListNode(int val) {
                this.val = val;
            }

            ListNode(int val, ListNode next) {
                this.val = val;
                this.next = next;
            }
        }

        private ListNode start;

        public MyHashSet() {
        }

        public void add(int key) {
            if (contains(key))
                return;

            if (start == null) {
                System.out.println("First");
                start = new ListNode(key);
                return;
            }

            ListNode temp = start;

            while (temp.next != null)
                temp = temp.next;

            temp.next = new ListNode(key);
        }

        public void remove(int key) {
            if (!contains(key))
                return;

            if (start == null)
                return;

            ListNode temp = start;

            if (start.val == key) {
                start = start.next;
                return;
            }

            while (temp.next != null) {
                if (temp.next.val == key) {
                    temp.next = temp.next.next;
                    return;
                }
                temp = temp.next;
            }
        }

        public boolean contains(int key) {
            ListNode temp = start;

            if (temp == null)
                return false;

            while (temp != null) {
                if (temp.val == key)
                    return true;

                temp = temp.next;
            }

            return false;
        }

        public void show() {
            ListNode temp = start;

            while (temp != null) {
                System.out.print(temp.val + " ");
                temp = temp.next;
            }
        }
    }
}