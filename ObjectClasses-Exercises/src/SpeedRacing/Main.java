package SpeedRacing;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Map<String, Car> carList = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] token = scanner.nextLine().split("\\s+");

            String model = token[0];
            Car car = getCar(token[1], token[2]);
            carList.put(model, car);
        }
        String read;
        while (!"End".equals(read = scanner.nextLine())) {
            String[] token = read.split("\\s+");
            String model = token[1];
            if (carList.containsKey(model)) {
                int km = Integer.parseInt(token[2]);
                carList.get(model).setDistance(km);
                carList.put(model, carList.get(model));
            }
        }
        carList.forEach((model, spec) -> System.out.println(model + " " + spec));
    }

    private static Car getCar(String s, String s1) {
        double fuelAmount = Double.parseDouble(s);
        double fuelCoast = Double.parseDouble(s1);
        return new Car(fuelAmount, fuelCoast);
    }
}
