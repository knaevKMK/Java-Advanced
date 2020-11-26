import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class AppliedArithmetics {
    private static Scanner scanner = new Scanner(System.in);
    private static int[] nums;
    private static Function<int[], int[]> add = n -> Arrays.stream(n).boxed().mapToInt(e -> e + 1).toArray();
    private static Function<int[], int[]> multiply = n -> Arrays.stream(n).boxed().mapToInt(e -> e * 2).toArray();
    private static Function<int[], int[]> subtract = n -> Arrays.stream(n).boxed().mapToInt(e -> e - 1).toArray();
    private static Consumer<int[]> print = n -> Arrays.stream(n).forEach(e -> System.out.print(e + " "));

    public static void main(String[] args) {
        nums = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        while (true) {
            Function<int[], int[]> function = null;
            switch (scanner.nextLine()) {
                case "end":
                    return;
                case "add":
                    function = add;
                    break;
                case "multiply":
                    function = multiply;
                    break;
                case "subtract":
                    function = subtract;
                    break;
                case "print":
                    print.accept(nums);
                    System.out.println();
                    continue;
            }
            assert function != null;
            nums = function.apply(nums);

        }
    }
}
