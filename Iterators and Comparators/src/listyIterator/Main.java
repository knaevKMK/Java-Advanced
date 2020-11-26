package listyIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> data = Arrays.stream(scanner.nextLine().split("\\s+")).skip(1).collect(Collectors.toCollection(ArrayList::new));
        ListyIterator listyIterator = new ListyIterator(data);

        while (true) {
            switch (scanner.nextLine()) {
                case "END":
                    return;
                case "Move":
                    printResult(String.valueOf(listyIterator.move()));
                    break;
                case "Print":
                    printResult(listyIterator.print());
                    break;
                case "HasNext":
                    printResult(String.valueOf(listyIterator.hasNext()));
                    break;
                case "PrintAll":
                    printResult(listyIterator.printAll());
            }
        }

    }

    private static void printResult(String print) {
        System.out.println(print);
    }
}
