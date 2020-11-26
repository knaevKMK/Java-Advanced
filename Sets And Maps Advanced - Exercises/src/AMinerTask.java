import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Map<String, Integer> list = new LinkedHashMap<>();
        String read;
        int i = 0;
        String name = "";
        while (!"stop".equals(read = scanner.nextLine())) {
            i++;
            if (i % 2 == 1) {
                name = read;
            } else {
                list.putIfAbsent(name, 0);
                int counter = list.get(name)+Integer.parseInt(read);;
                list.put(name, counter);
            }
        }
        list.forEach((k, v) -> System.out.println(k + " -> " + v));
    }
}
