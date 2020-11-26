import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class FilterbyAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> list = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            list.offer(scanner.nextLine());
        }
        String step = scanner.nextLine();
        Integer age = Integer.parseInt(scanner.nextLine());
        String[] format = scanner.nextLine().split("\\s+");
        boolean stepS = true;
        ArrayDeque<String> result = new ArrayDeque<>();
        while (!list.isEmpty()) {
            String[] line = list.pop().split(", ");
            String name = line[0];
            int ageName = Integer.parseInt(line[1]);
            switch (step) {
                case "younger":
                    stepS = age >= ageName;
                    break;
                case "older":
                    stepS = age <= ageName;
                    break;
            }
            if (stepS) {
                String add = "";
                if (format.length == 1) {
                    switch (format[0]) {
                        case "name":
                            add = name;
                            break;
                        case "age":
                            add = "" + ageName;
                            break;
                    }
                } else {
                    add = name + " - " + ageName;
                }
                result.offer(add);
            }
        }
        while (!result.isEmpty()) {
            System.out.println(result.pop());
        }

    }
}