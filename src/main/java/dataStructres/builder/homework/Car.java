package dataStructres.builder.homework;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Car {
    private final String brand;
    private final String model;
    private final int year;
    private final String color;

    private Car(CarBuilder builder) {
        this.brand = builder.getBrand();
        this.model = builder.getModel();
        this.year = builder.getYear();
        this.color = builder.getColor();
    }

    public interface CarBuilder {
        CarBuilder setBrand(String brand);

        CarBuilder setModel(String model);

        CarBuilder setYear(int year);

        CarBuilder setColor(String color);

        Car build();

        String getBrand();

        String getModel();

        int getYear();

        String getColor();
    }

    public static class CarBuilderImpl implements CarBuilder {
        private String brand;
        private String model;
        private int year;
        private String color;

        @Override
        public CarBuilder setBrand(String brand) {
            this.brand = brand;
            return this;
        }

        @Override
        public CarBuilder setModel(String model) {
            this.model = model;
            return this;
        }

        @Override
        public CarBuilder setYear(int year) {
            this.year = year;
            return this;
        }

        @Override
        public CarBuilder setColor(String color) {
            this.color = color;
            return this;
        }

        @Override
        public Car build() {
            return new Car(this);
        }

        @Override
        public String getBrand() {
            return brand;
        }

        @Override
        public String getModel() {
            return model;
        }

        @Override
        public int getYear() {
            return year;
        }

        @Override
        public String getColor() {
            return color;
        }
    }
}