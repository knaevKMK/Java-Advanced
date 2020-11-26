package RawData;

public class Tyre {
    //> <Tire1Pressure> <Tire1Age> <Tire2Pressure> <Tire2Age> <Tire3Pressure> <Tire3Age> <Tire4Pressure> <Tire4Age>
    double pressure1;
    double old1;
    double pressure2;
    double old2;
    double pressure3;
    double old3;
    double pressure4;
    double old4;

    public Tyre(double[] tyres) {
        this.pressure1 = tyres[0];
        this.old1 = tyres[1];
        this.pressure2 = tyres[2];
        this.old2 = tyres[3];
        this.pressure3 = tyres[4];
        this.old3 = tyres[5];
        this.pressure4 = tyres[6];
        this.old4 = tyres[7];
    }

    public boolean lowPressure() {
        if (this.pressure1 < 1 || this.pressure2 < 1 || this.pressure3 < 1 || this.pressure4 < 1) {
            return true;
        }
        return false;
    }

}
