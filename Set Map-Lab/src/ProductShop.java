import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Map<String, Map<String, Double>> shops = new TreeMap<>();
        String read;
        while (!"Revision".equals(read = scanner.nextLine())) {
            String[] token = read.split(",\\s");
            shops.putIfAbsent(token[0], new LinkedHashMap<String, Double>());
            shops.get(token[0]).putIfAbsent(token[1], 0.0);
            shops.get(token[0]).put(token[1], Double.parseDouble(token[2]));
        }

        for (Map.Entry<String, Map<String, Double>> shop : shops.entrySet()) {
            System.out.println(shop.getKey() + "->");
            for (Map.Entry<String, Double> product : shop.getValue().entrySet())
                System.out.println(String.format("Product: %s, Price: %.1f", product.getKey(), product.getValue()));
        }
    }
}

