package CarInfo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            String[] token = scanner.nextLine().split(" ");
            Car car = new Car();
            car.setBrand(token[0]);
            car.setModel(token[1]);
            car.setHorsrePower(Integer.parseInt(token[2]));
            System.out.println(String.format("The car is: %s %s - %d HP.", car.getBrand(), car.getModel(), car.getHorsrePower()));
        }


    }
}
