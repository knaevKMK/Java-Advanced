import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindSmallestElement {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Integer> list = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        Function<List<Integer>, Integer> indexOfMin = nums -> {
            int min = nums.get(0);
            int index = 0;
            for (int i = 0; i < nums.size(); i++) {
                if (min >= nums.get(i)){
                    min = nums.get(i);
                    index = i;
                }
            }
            return index;
        };
        System.out.println(indexOfMin.apply(list));
    }
}
