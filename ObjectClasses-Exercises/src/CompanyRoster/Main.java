package CompanyRoster;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, List<Employee>> departmentList = new HashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String department = tokens[3];
            departmentList.putIfAbsent(department, new ArrayList<>());

            Employee employee = getEmploee(tokens);

            departmentList.get(department).add(employee);
        }
        departmentList.entrySet().stream()
                .sorted((l, h) -> Double.compare(getAverage(h), getAverage(l)))
                .limit(1)
                .forEach(e-> {
                    System.out.println("Highest Average Salary: "+ e.getKey());
                    e.getValue()
                            .stream()
                            .sorted((l, h) -> Double.compare(h.salary,l.salary))
                            .forEach(System.out::println);
                });

    }

    private static double getAverage(Map.Entry<String, List<Employee>> h) {
        return h.getValue().stream().mapToDouble(e -> e.salary).average().orElse(0.0);

    }

    private static Employee getEmploee(String[] tokens) {
        String name = tokens[0];
        double salary = Double.parseDouble(tokens[1]);
        String position = tokens[2];
        String email;
        int age;
        switch (tokens.length) {
            case 6:
                email = tokens[4];
                age = Integer.parseInt(tokens[5]);
                return new Employee(name, salary, position, email, age);

            case 4:
                return new Employee(name, salary, position);

            case 5:
                try {
                    age = Integer.parseInt(tokens[4]);
                    return new Employee(name, salary, position, age);
                } catch (NumberFormatException exception) {
                    email = tokens[4];
                    return new Employee(name, salary, position, email);
                }
            default:
                throw new IllegalStateException("Unexpected value: " + tokens.length);
        }
    }
}
