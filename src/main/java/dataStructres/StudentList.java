package dataStructres;

public class StudentList {
    private class Node {
        int id;
        String name;
        float grade;
        Node next;

        public Node(int id, String name, float grade) {
            this.id = id;
            this.name = name;
            this.grade = grade;
        }

        public Node(int id, String name, float grade, Node next) {
            this.id = id;
            this.name = name;
            this.grade = grade;
            this.next = next;
        }

        public Node() {
        }
    }
}