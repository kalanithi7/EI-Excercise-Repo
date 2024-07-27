package Excercise1.CreationalDesignPattern;

class Computer {
    private String cpu;
    private String ram;
    private String storage;
    private String gpu;

    private Computer(ComputerBuilder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.gpu = builder.gpu;
    }

    public void displaySpecs() {
        System.out.println("CPU: " + cpu + ", RAM: " + ram + ", Storage: " + storage + ", GPU: " + gpu);
    }

    public static class ComputerBuilder {
        private String cpu;
        private String ram;
        private String storage;
        private String gpu;

        public ComputerBuilder setCpu(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public ComputerBuilder setRam(String ram) {
            this.ram = ram;
            return this;
        }

        public ComputerBuilder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public ComputerBuilder setGpu(String gpu) {
            this.gpu = gpu;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}

public class BuilderPattern {
    public static void main(String[] args) {
        Computer customPc = new Computer.ComputerBuilder()
                .setCpu("Intel i7")
                .setRam("16GB")
                .setStorage("1TB SSD")
                .setGpu("NVIDIA RTX 3070")
                .build();

        customPc.displaySpecs();
    }
}

