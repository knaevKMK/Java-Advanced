package google;

public class Car {
    //•	"<Name> car <carModel> <carSpeed>"
    String model;
    int speed;

    public Car(String line) {
        this.model = line.split("\\s+")[0];
        this.speed = Integer.parseInt(line.split("\\s+")[1]);
    }

    @Override
    public String toString() {
        return this.model + " " + this.speed+"\n";
    }
}
