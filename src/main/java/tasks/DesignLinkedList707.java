package tasks;

public class DesignLinkedList707 {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1, 2);

        myLinkedList.show();

        System.out.println(myLinkedList.get(1));

        myLinkedList.deleteAtIndex(1);

        myLinkedList.show();

        System.out.println(myLinkedList.get(1));
    }

    static class MyLinkedList {
        ListNode crn;
        int size;

        public void show() {
            ListNode temp = crn;
            while (temp != null) {
                System.out.print(temp.val + " ");
                temp = temp.next;
            }
            System.out.println();
        }

        class ListNode {
            int val;
            ListNode next;

            ListNode(int val) {
                this.val = val;
            }
        }

        public MyLinkedList() {
            this.size = 0;
        }

        public int get(int index) {
            ListNode temp = crn;

            while (index > 0) {
                temp = temp.next;
                index--;
            }
            return temp.val;
        }

        public void addAtHead(int val) {
            if (crn == null) {
                crn = new ListNode(val);
            } else {
                ListNode temp = crn;
                crn = new ListNode(val);
                crn.next = temp;
            }
            size++;
        }

        public void addAtTail(int val) {
            ListNode temp = crn;

            while (temp.next != null)
                temp = temp.next;

            temp.next = new ListNode(val);

            size++;
        }

        public void addAtIndex(int index, int val) {
            ListNode temp = crn;

            while (index > 0) {
                temp = temp.next;
                index--;
            }

            ListNode newNode = new ListNode(val);
            newNode.next = temp.next;
            temp.next = newNode;
            size++;
        }

        public void deleteAtIndex(int index) {
            ListNode temp = crn;
            while (index > 0) {
                temp = temp.next;
                index--;
            }
            temp.next = temp.next.next;
            size--;
        }
    }
}