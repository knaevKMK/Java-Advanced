import javax.swing.plaf.IconUIResource;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Map<String, String> list = getMap();
        list.forEach((k, v) -> System.out.println(k + " -> " + v));
    }

    private static Map<String, String> getMap() {
        Map<String, String> map = new LinkedHashMap<>();
        String read;
        int i = 0;
        String name = "";
        while (!"stop".equals(read = scanner.nextLine())) {
            i++;
            if (i % 2 == 1) {
                name = read;
            } else {
                String check = read.substring(read.lastIndexOf(".")+1);
                if (check.equals("com") || check.equals("uk") || check.equals("us")) {
                    continue;
                }
                map.put(name, read);
            }
        }
        return map;
    }
}
