package CarSalesman;

public class Car {
    //model, engine, weight and color
    private String model;
    private Engine engine;
    //Oprional
    private int weight;
    private String color;

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
        this.weight = 0;
        this.color = "n/a";
    }

    public Car(String model, Engine engine, int weight, String color) {
        this(model, engine);
        this.weight = weight;
        this.color = color;
    }

    public Car(String model, Engine engine, int weight) {
        this(model, engine);
        this.weight = weight;
    }

    public Car(String model, Engine engine, String color) {
        this(model, engine);
        this.color = color;
    }


    @Override
    public String toString() {
        String printWeight = "" + this.weight;
        if (this.weight == 0) {
            printWeight = "n/a";
        }
        return String.format(this.model + ":%n" + this.engine + "%nWeight: " + printWeight + "%nColor: " + this.color);
    }

}
