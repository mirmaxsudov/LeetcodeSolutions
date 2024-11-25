package univer_lesson.builder;

import lombok.Getter;
import lombok.ToString;
import lombok.AllArgsConstructor;

@Getter
@ToString
@AllArgsConstructor
public class Computer {
    private String cpu;
    private String ram;
    private String hdd;

    public Computer(ComputerBuilder computerBuilder) {
        this.cpu = computerBuilder.cpu;
        this.ram = computerBuilder.ram;
        this.hdd = computerBuilder.hdd;
    }


    public static class ComputerBuilder {
        private String cpu;
        private String ram;
        private String hdd;

        public ComputerBuilder setCpu(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public ComputerBuilder setRam(String ram) {
            this.ram = ram;
            return this;
        }

        public ComputerBuilder setHdd(String hdd) {
            this.hdd = hdd;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}