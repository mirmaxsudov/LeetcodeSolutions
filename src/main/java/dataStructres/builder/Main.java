package dataStructres.builder;

public class Main {
    public static void main(String[] args) {
        Car kabolat = new Car.CarBuilder(
                "Kabolat",
                "Chevrolet",
                "Black",
                "4"
        ).build();

        Car lambo = new Car.CarBuilder(
                "lambo",
                "Lamborjini",
                "Red",
                "2"
        )
                .setAutomatic(true)
                .setSunroof(true)
                .build();

        System.out.println(kabolat);
        System.out.println(lambo);
    }
}