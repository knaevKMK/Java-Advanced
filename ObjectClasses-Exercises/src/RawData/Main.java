package RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Car> fragile = new ArrayList<>();
        List<Car> flamable = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] token = scanner.nextLine().split("\\s+", 6);
            int enginePower = Integer.parseInt(token[2]);

            Car car = new Car(token);
            switch (token[4]) {
                case "fragile":
                    if (car.pressure()) {
                        fragile.add(car);
                    }
                    break;
                case "flamable":
                    if (enginePower > 250) {
                        flamable.add(car);
                    }
                    break;
            }
        }
        switch (scanner.nextLine()) {
            case "fragile":
                fragile.forEach(System.out::println);
                break;
            case "flamable":
                flamable.forEach(System.out::println);
                break;
        }
    }
}
