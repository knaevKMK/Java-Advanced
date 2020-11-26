import java.util.Scanner;
import java.util.function.Consumer;

public class ConsumerPrint {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] read = scanner.nextLine().split("\\s+");
        Consumer consumer = x -> System.out.println("Sir "+x);
        for (String s : read) {
            consumer.accept(s);
        }
    }
}
