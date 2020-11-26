import java.util.*;

public class CitiesContinentCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, LinkedHashMap<String, List<String>>> list = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split("\\s");
            list.putIfAbsent(line[0], new LinkedHashMap<>());
            list.get(line[0]).putIfAbsent(line[1], new ArrayList<>());
            list.get(line[0]).get(line[1]).add(line[2]);
        }
        list.forEach((k, v) -> {
            System.out.println(k + ":");
            v.entrySet().forEach((country) -> System.out.println("  " + country.getKey() + " -> " + country.getValue().toString().replaceAll("[\\[\\]]", "")));
        });
    }
}
