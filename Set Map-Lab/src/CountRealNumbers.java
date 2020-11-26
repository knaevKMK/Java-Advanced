import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class CountRealNumbers {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        LinkedHashMap<Double, Integer> nums = getMap();
        nums.forEach((key, value) -> System.out.println(String.format("%.1f -> %d",key , value)));
    }

    private static LinkedHashMap<Double, Integer> getMap() {
        LinkedHashMap<Double, Integer> nums = new LinkedHashMap<>();
        double[] number = Arrays.stream(scanner.nextLine().split("\\s"))
                .mapToDouble(Double::parseDouble).toArray();
        for (double v : number) {
            nums.putIfAbsent(v, 0);
            int counter = nums.get(v) + 1;
            nums.put(v, counter);
        }
        return nums;
    }
}
