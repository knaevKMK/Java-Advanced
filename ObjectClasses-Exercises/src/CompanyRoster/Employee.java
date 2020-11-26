package CompanyRoster;

public class Employee {
    // constant
    String name;
    double salary;
    String position;

    // optional
    String email;
    int age ;

    public Employee(String name, double salary, String position, String email, int age) {
        this(name, salary, position);
        this.email = email;
        this.age = age;
    }

    public Employee(String name, double salary, String position, String email) {
        this(name, salary, position);
        this.email = email;
        this.age = -1;
    }

    public Employee(String name, double salary, String position, int age) {
        this(name, salary, position);
        this.email = "n/a";
        this.age = age;
    }

    public Employee(String name, double salary, String position) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.email = "n/a";
        this.age = -1;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %s %d", this.name, this.salary, this.email, this.age);

    }

}
