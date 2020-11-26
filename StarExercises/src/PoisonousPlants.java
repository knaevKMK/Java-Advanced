import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class PoisonousPlants {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Integer> plants = new ArrayDeque<>();
        int n = Integer.parseInt(scanner.readLine());
        Arrays.stream(scanner.readLine().split("\\s")).mapToInt(Integer::parseInt).forEach(e -> plants.push(e));

        int day = 0;
        while (!plants.isEmpty()) {

            for (int i = 1; i < n; i++) {
                int last = plants.pop();
                if (last > plants.peek()) {
                    continue;
                }
                plants.offer(last);
            }
            plants.offer(plants.pop());// re-write the last in the begining
            if (n == plants.size()) {
                break;
            }
            n = plants.size();
            day++;
        }
        System.out.println(day);
    }
}
