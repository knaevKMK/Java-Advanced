package Contrusctors;

public class Car {
    public String brand;
    public String model;
    public int horsePower;

    public Car(String brand, String model, int horsePower) {
        this(brand, model);
        this.horsePower = horsePower;
    }

    public Car(String brand, String model) {
        this(brand);
        this.model = model;
        this.horsePower = -1;

    }

    public Car(String brand) {
        this.brand = brand;
        this.model = "unknown";
        this.horsePower = -1;
    }

    @Override
    public String toString() {
        return String.format("The car is: %s %s - %d HP.", this.brand, this.model, this.horsePower);
    }
}
