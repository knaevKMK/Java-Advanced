import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class CustomMinFunction {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] nums = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Function<int[], Integer> getMin = n -> {
            int min = nums[0];
            for (int num : nums) {
                if (min > num) {
                    min = num;
                }
            }
            return min;
        };


        System.out.println(getMin.apply(nums));
    }
}
