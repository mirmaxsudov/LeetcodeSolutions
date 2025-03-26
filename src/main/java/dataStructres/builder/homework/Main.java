package dataStructres.builder.homework;

public class Main {
    public static void main(String[] args) {
        Car car = new Car.CarBuilderImpl()
                .setBrand("Tesla")
                .build();

        System.out.println(car);
    }
}