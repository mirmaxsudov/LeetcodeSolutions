package univer_lesson;

public class TowerOfHanoi {

    public static void main(String[] args) {
        h(3, 'A', 'B', 'C');
    }

    public static void h(int n, char source, char auxiliary, char destination) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + source + " to " + destination);
            return;
        }

        h(n - 1, source, destination, auxiliary);

        System.out.println("Move disk " + n + " from " + source + " to " + destination);

        h(n - 1, auxiliary, source, destination);
    }
}