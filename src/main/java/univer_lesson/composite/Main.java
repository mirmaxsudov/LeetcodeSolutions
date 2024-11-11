package univer_lesson.composite;

public class Main {
    public static void main(String[] args) {
        Component hardDisk = new Leaf("Hard Disk", 500);
        Component mouse = new Leaf("Mouse", 100);

        Composite computer = new Composite("Computer");
        computer.addComponent(hardDisk);
        computer.addComponent(mouse);

        computer.showPrice();

    }
}