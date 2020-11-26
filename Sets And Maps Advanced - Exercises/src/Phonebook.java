import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Phonebook {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Map<String, String> phoneList = new TreeMap<>();
        String read;
        while (!"search".equals(read = scanner.nextLine())) {
            String[] token = read.split("-");
            phoneList.put(token[0], token[1]);
        }

        while (!"stop".equals(read = scanner.nextLine())) {
            if (phoneList.containsKey(read)) {
                read = read + " -> " + phoneList.get(read);
            } else {
                read = "Contact " + read + " does not exist.";
            }
            System.out.println(read);
        }
    }
}
