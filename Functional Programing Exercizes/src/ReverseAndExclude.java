import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        BiFunction<List<Integer>, Integer, List<Integer>> consumer = (n, d) -> n.stream().filter(e -> e % d != 0).collect(Collectors.toList());
        String[] read = scanner.nextLine().split("\\s+");
        List<Integer> list = new ArrayList<>();

        for (int i = read.length-1; i >=0 ; i--) {
            list.add(Integer.parseInt(read[i]));
        }

        int n = Integer.parseInt(scanner.nextLine());
        list = consumer.apply(list, n);
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
    }
}
