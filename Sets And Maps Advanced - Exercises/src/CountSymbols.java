import java.util.*;

public class CountSymbols {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Map<Character, Integer> list = new TreeMap<>();
        String read = scanner.nextLine();
        for (int i = 0; i < read.length(); i++) {
            char s = read.charAt(i);
            list.putIfAbsent(s, 0);
            int counter = list.get(s) + 1;
            list.put(s, counter);
        }
        list.forEach((k, v) -> System.out.println(k + ": " + v + " time/s"));
    }
}
