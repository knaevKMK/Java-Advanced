package SpeedRacing;

public class Car {
    // fuel amount, fuel cost for 1 kilometer and distance traveled.
    double fuelAmount;
    double fuelCoast;
    int km;

    public Car(double fuelAmount, double fuelCoast) {
        this.fuelAmount = fuelAmount;
        this.fuelCoast = fuelCoast;
        this.km = 0;
    }

    public void setDistance(int km) {
        if (km * this.fuelCoast > this.fuelAmount) {
            System.out.println("Insufficient fuel for the drive");
            return;
        }
        this.fuelAmount = this.fuelAmount - (km * this.fuelCoast);
        this.km += km;
    }

    @Override
    public String toString() {
        return String.format("%.2f %d", fuelAmount, km);
    }
}
