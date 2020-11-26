package Contrusctors;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] token = scanner.nextLine().split("\\s");
            Car car;
            switch (token.length) {
                case 1:
                    car = new Car(token[0]);
                    break;
                case 2:
                    car = new Car(token[0], token[1]);

                    break;
                case 3:
                    car = new Car(token[0], token[1], Integer.parseInt(token[2]));
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + token.length);
            }
            System.out.println(car);

        }
    }
}
