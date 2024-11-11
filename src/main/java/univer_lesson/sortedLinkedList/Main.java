package univer_lesson.sortedLinkedList;

public class Main {
    public static void main(String[] args) {
        MySortedLinkedList sortedLinkedList = new MySortedLinkedList();

        sortedLinkedList.insert(6);
        sortedLinkedList.insert(4);
        sortedLinkedList.insert(3);
        sortedLinkedList.insert(21);

        System.out.println("sortedLinkedList = " + sortedLinkedList);

        sortedLinkedList.delete();

        System.out.println("sortedLinkedList = " + sortedLinkedList);

        sortedLinkedList.delete(2);

        System.out.println("sortedLinkedList = " + sortedLinkedList);
    }
}