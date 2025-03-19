package dataStructres.builder;

public class House {
    private String type;
    private int numberOfRooms;
    private int numberOfWindows;
    private int numberOfOutdoors;
    private boolean hasGarage;
    private boolean hasSwimmingPool;
    private boolean hasGarden;
    private boolean hasFountain;
    private boolean hasStatue;

    private House(String type, int numberOfRooms, int numberOfWindows, int numberOfOutdoors, boolean hasGarage, boolean hasSwimmingPool, boolean hasGarden, boolean hasFountain, boolean hasStatue) {
        this.type = type;
        this.numberOfRooms = numberOfRooms;
        this.numberOfWindows = numberOfWindows;
        this.numberOfOutdoors = numberOfOutdoors;
        this.hasGarage = hasGarage;
        this.hasSwimmingPool = hasSwimmingPool;
        this.hasGarden = hasGarden;
        this.hasFountain = hasFountain;
        this.hasStatue = hasStatue;
    }

    private House(HouseBuilder houseBuilder) {
        this.type = houseBuilder.type;
        this.numberOfRooms = houseBuilder.numberOfRooms;
        this.numberOfWindows = houseBuilder.numberOfWindows;
        this.numberOfOutdoors = houseBuilder.numberOfOutdoors;
        this.hasGarage = houseBuilder.hasGarage;
        this.hasSwimmingPool = houseBuilder.hasSwimmingPool;
        this.hasGarden = houseBuilder.hasGarden;
        this.hasFountain = houseBuilder.hasFountain;
        this.hasStatue = houseBuilder.hasStatue;
    }

    public static class HouseBuilder {
        private String type;
        private int numberOfRooms;
        private int numberOfWindows;
        private int numberOfOutdoors;
        private boolean hasGarage;
        private boolean hasSwimmingPool;
        private boolean hasGarden;
        private boolean hasFountain;
        private boolean hasStatue;

        public HouseBuilder(
                String type,
                int numberOfRooms,
                int numberOfWindows,
                int numberOfOutdoors
        ) {
            this.type = type;
            this.numberOfRooms = numberOfRooms;
            this.numberOfWindows = numberOfWindows;
            this.numberOfOutdoors = numberOfOutdoors;
        }

        public HouseBuilder setGarage(boolean hasGarage) {
            this.hasGarage = hasGarage;
            return this;
        }

        public HouseBuilder setSwimmingPool(boolean hasSwimmingPool) {
            this.hasSwimmingPool = hasSwimmingPool;
            return this;
        }

        public HouseBuilder setGarden(boolean hasGarden) {
            this.hasGarden = hasGarden;
            return this;
        }

        public HouseBuilder setFountain(boolean hasFountain) {
            this.hasFountain = hasFountain;
            return this;
        }

        public HouseBuilder setStatue(boolean hasStatue) {
            this.hasStatue = hasStatue;
            return this;
        }

        public House build() {
            return new House(
                    this
            );
        }
    }

    @Override
    public String toString() {
        return "House{" +
                "type='" + type + '\'' +
                ", numberOfRooms=" + numberOfRooms +
                ", numberOfWindows=" + numberOfWindows +
                ", numberOfOutdoors=" + numberOfOutdoors +
                ", hasGarage=" + hasGarage +
                ", hasSwimmingPool=" + hasSwimmingPool +
                ", hasGarden=" + hasGarden +
                ", hasFountain=" + hasFountain +
                ", hasStatue=" + hasStatue +
                '}';
    }
}