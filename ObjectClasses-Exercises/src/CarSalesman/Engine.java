package CarSalesman;

public class Engine {
    //has model, power,
    private String model;
    private int power;
    // Optional-displacement and efficiency.
    private int displacement;
    private String efficiency;

    public Engine(String model, int power) {
        this.model = model;
        this.power = power;
        this.displacement = 0;
        this.efficiency = "n/a";
    }

    public Engine(String model, int power, int displacement, String efficiency) {
        this(model, power);
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public Engine(String model, int power, int displacement) {
        this(model, power);
        this.displacement = displacement;

    }

    public Engine(String model, int power, String efficiency) {
        this(model, power);
        this.efficiency = efficiency;
    }

    @Override
    public String toString() {
        String printDisplacement = "" + this.displacement;
        if (this.displacement == 0) {
            printDisplacement = "n/a";
        }
        return String.format(this.model + ":%n" + "Power: " + this.power + "%nDisplacement: " + printDisplacement + "%nEfficiency: " + this.efficiency);
    }
}
