import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateNames {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int d=Integer.parseInt(scanner.nextLine());
        Predicate<String> predicate = string -> string.length() <= d;
        List<String> list = Arrays.stream(scanner.nextLine().split("\\s+")).filter(predicate).collect(Collectors.toList());
        list.forEach(System.out::println);
    }
}
