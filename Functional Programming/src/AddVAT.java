import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        UnaryOperator<Double> addVat = price -> price * 1.2;
        String[] read = scanner.nextLine().split(", ");
        List<Double> result = new ArrayList<>();
        for (String s : read) {
            result.add(addVat.apply(Double.parseDouble(s)));
        }
        System.out.println("Prices with VAT:");
        result.forEach(e-> System.out.printf("%.2f%n",e));
    }
}
