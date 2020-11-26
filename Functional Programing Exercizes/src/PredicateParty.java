import com.sun.jdi.PathSearchingVirtualMachine;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<String> list = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String read;
        while (!"Party!".equals(read = scanner.nextLine())) {
            String[] token = read.split("\\s+");
            switch (token[0]) {
                case "Remove":
                    list.removeIf(getPredicate(token));
                    break;
                case "Double":
                    for (int i = 0; i < list.size(); i++) {
                        if (getPredicate(token).test(list.get(i))) {
                            list.add(i, list.get(i++));
                        }
                    }
                    break;
            }
        }
        if (list.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            StringBuilder print = new StringBuilder();
            list.forEach(e -> print.append(e).append(", "));
            print.deleteCharAt(print.length() - 2);
            print.append("are going to the party!");
            System.out.println(print);
        }
    }

    private static Predicate<String> getPredicate(String[] read) {

        switch (read[1]) {
            case "Length":
                int lenght = Integer.parseInt(read[2]);
                return s -> s.length() == lenght;
            case "StartsWith":
                return s -> s.substring(0, read[2].length()).equals(read[2]);
            case "EndsWith":
                return s -> s.substring(s.length() - read[2].length()).equals(read[2]);
            default:
                return null;
        }
    }
}
