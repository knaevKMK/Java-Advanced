package google;

public class Company {
    String name;
    String department;
    double salary;

    public Company(String line) {
        this.name = line.split("\\s+")[0];
        this.department = line.split("\\s+")[1];
        this.salary = Double.parseDouble(line.split("\\s+")[2]);
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f%n", this.name, this.department, this.salary);
    }

}
