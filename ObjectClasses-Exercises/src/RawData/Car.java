package RawData;

import java.util.Arrays;

public class Car {
    //"<Model> <EngineSpeed> <EnginePower> <CargoWeight> <CargoType>
    String model;
    int engineSpeed;
    int enginePower;
    int cargoWeight;
    Tyre tyres;

    public Car(String[] token) {
        this.model = token[0];
        this.engineSpeed = Integer.parseInt(token[1]);
        this.enginePower = Integer.parseInt(token[2]);
        this.cargoWeight = Integer.parseInt(token[3]);
        this.tyres = new Tyre(Arrays.stream(token[5].split("\\s+")).mapToDouble(Double::parseDouble).toArray());
    }

    public boolean pressure() {
        return tyres.lowPressure();
    }

    @Override
    public String toString() {
        return model;
    }
}
