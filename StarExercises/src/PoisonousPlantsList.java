import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PoisonousPlantsList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Integer> plants = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());


        int day = 0;
        while (!plants.isEmpty()) {
            for (int i = n - 1; i > 0; i--) {
                if (plants.get(i) > plants.get(i - 1)) {
                    plants.remove(i);
                }
            }
            if (plants.size() == n) {
                break;
            }
            n = plants.size();
            day++;
        }
        System.out.println(day);
    }
}
