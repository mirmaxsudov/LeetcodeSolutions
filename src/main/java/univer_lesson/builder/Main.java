package univer_lesson.builder;

public class Main {
    public static void main(String[] args) {
        Computer laptop = new Computer.ComputerBuilder()
                .setCpu("Intel Core i7")
                .setRam("16GB")
                .setHdd("1TB")
                .build();

        Computer desktop = new Computer.ComputerBuilder()
                .setCpu("Intel Core i5")
                .setRam("8GB")
                .setHdd("500GB")
                .build();

        System.out.println("laptop = " + laptop);
        System.out.println("desktopw = " + desktop);
    }
}