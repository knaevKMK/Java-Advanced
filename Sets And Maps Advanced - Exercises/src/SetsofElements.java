import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsofElements {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        LinkedHashSet<Integer> nLine = setSet(n);
        LinkedHashSet<Integer> mLine = setSet(m);

        for (Integer integer : nLine) {
            for (Integer integer1 : mLine) {
                if (integer == integer1) {
                    System.out.print(integer + " ");
                }
            }
        }
    }

    private static LinkedHashSet<Integer> setSet(int elements) {
        LinkedHashSet<Integer> line = new LinkedHashSet<>();
        for (int i = 0; i < elements; i++) {
            line.add(Integer.parseInt(scanner.nextLine()));
        }
        return line;
    }
}
