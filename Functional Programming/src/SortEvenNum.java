import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SortEvenNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

 //       Predicate<Integer> isEven = n -> n % 2 == 0;
        List<Integer> list = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::valueOf)
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        //     list.removeIf(n -> n % 2 != 0);
        printResult(list.toString());
        list.sort((x, y) -> Integer.compare(x, y));
        printResult(list.toString());
    }

    private static void printResult(String out) {
        System.out.println(out.replaceAll("[\\[\\]]", ""));
    }
}
