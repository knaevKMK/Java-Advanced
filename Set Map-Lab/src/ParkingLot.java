import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> plate = new LinkedHashSet<>();
        String input;
        while (!"END".equals(input = scanner.nextLine())) {
            String[] token = input.split(",\\s");
            switch (token[0]) {
                case "IN":
                    plate.add(token[1]);
                    break;
                case "OUT":
                    plate.remove(token[1]);
                    break;
            }
        }
        if (plate.isEmpty()) {
            System.out.println("Parking Lot is Empty");
            return;
        }
        for (String s : plate) {
            System.out.println(s);
        }
    }
}
