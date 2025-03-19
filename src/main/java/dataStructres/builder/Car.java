package dataStructres.builder;

public class Car {
    private String model;
    private String brand;
    private String color;
    private String numberOfDoors;
    private boolean isAutomatic;
    private boolean hasSunroof;

    private Car(CarBuilder builder) {
        this.model = builder.model;
        this.brand = builder.brand;
        this.color = builder.color;
        this.numberOfDoors = builder.numberOfDoors;
        this.isAutomatic = builder.isAutomatic;
        this.hasSunroof = builder.hasSunroof;
    }

    public static class CarBuilder {
        private String model;
        private String brand;
        private String color;
        private String numberOfDoors;
        private boolean isAutomatic;
        private boolean hasSunroof;

        public CarBuilder(String model, String brand, String color, String numberOfDoors) {
            this.model = model;
            this.brand = brand;
            this.color = color;
            this.numberOfDoors = numberOfDoors;
        }

        public CarBuilder setAutomatic(boolean isAutomatic) {
            this.isAutomatic = isAutomatic;
            return this;
        }

        public CarBuilder setSunroof(boolean hasSunroof) {
            this.hasSunroof = hasSunroof;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", numberOfDoors='" + numberOfDoors + '\'' +
                ", isAutomatic=" + isAutomatic +
                ", hasSunroof=" + hasSunroof +
                '}';
    }
}