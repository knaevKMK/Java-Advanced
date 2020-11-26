import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Set<String> list = new TreeSet<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] read = scanner.nextLine().split("\\s");
            list.addAll(Arrays.asList(read));
        }
        list.forEach(a-> System.out.print(a+" "));
    }
}
