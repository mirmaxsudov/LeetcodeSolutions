package univer_lesson.doubleLinkendList;

public class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        linkedList.insertBeg(10);
        linkedList.insertBeg(20);
        linkedList.insertBeg(30);
        linkedList.insertBeg(40);

        System.out.println(linkedList);
        linkedList.deleteEnd();

        System.out.println(linkedList);
    }
}