package CarSalesman;

import java.util.ArrayDeque;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Map<String, Engine> engines = new LinkedHashMap<>();
        addEngines(engines);
        ArrayDeque<Car> carList = new ArrayDeque<>();
        addCars(carList, engines);
        printCars(carList);

    }

    private static void printCars(ArrayDeque<Car> carList) {
        while (!carList.isEmpty()) {
            System.out.println(carList.pop());
        }
    }

    private static void addCars(ArrayDeque<Car> carList, Map<String, Engine> engines) {
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] token = scanner.nextLine().split("\\s+");

            String model = token[0];
            String engineName = (token[1]);

            int weight;
            String color;


            Car car;
            if (token.length == 2) {
                car = new Car(model, engines.get(engineName));
            } else if (token.length == 4) {
                weight = Integer.parseInt(token[2]);
                color = token[3];
                car = new Car(model, engines.get(engineName), weight, color);
            } else {
                try {
                    weight = Integer.parseInt(token[2]);
                    car = new Car(model, engines.get(engineName), weight);
                } catch (NumberFormatException e) {
                    color = token[2];
                    car = new Car(model, engines.get(engineName), color);
                }
            }
            carList.offer(car);
        }
    }

    private static void addEngines(Map<String, Engine> engines) {
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] token = scanner.nextLine().split("\\s+");
            String model = token[0];
            int power = Integer.parseInt(token[1]);
            int displacement;
            String efficiency;

            Engine engine;
            if (token.length == 2) {
                engine = new Engine(model, power);
            } else if (token.length == 4) {
                displacement = Integer.parseInt(token[2]);
                efficiency = token[3];
                engine = new Engine(model, power, displacement, efficiency);
            } else {
                try {
                    displacement = Integer.parseInt(token[2]);
                    engine = new Engine(model, power, displacement);
                } catch (NumberFormatException e) {
                    efficiency = token[2];
                    engine = new Engine(model, power, efficiency);
                }
            }
            engines.put(model, engine);
        }
    }
}
