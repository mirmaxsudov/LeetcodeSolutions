package dataStructres.builder.homework;

public class Main {
    public static void main(String[] args) {
        Car car = new Car.CarBuilderImpl()
                .build();
    }
}
