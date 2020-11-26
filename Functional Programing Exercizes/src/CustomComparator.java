import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CustomComparator {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Comparator<Integer> sort = (x, y) -> {
            int result = Integer.compare(Math.abs(x % 2), Math.abs(y % 2));
            if (result == 0) {
                result = Integer.compare(x, y);
            }
            return result;
        };
        List<Integer> list = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .sorted(sort)
                .collect(Collectors.toList());
        list.forEach(e-> System.out.print(e+" "));
    }

}
