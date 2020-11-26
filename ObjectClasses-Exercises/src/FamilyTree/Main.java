package FamilyTree;
import java.util.*;
public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String adam = scanner.nextLine();

        List<String> personList = new ArrayList<>();
        ArrayDeque<String> lines = new ArrayDeque<>();

        Person personAdam = new Person(adam);
        String read;
        while (!"End".equals(read = scanner.nextLine())) {
            if (read.contains("-")) {
                lines.offer(read);
            } else {
                if (read.contains(adam)) {
                    adam = read;
                    personAdam = new Person(read);
                }
                personList.add(read);
            }
        }

        while (!lines.isEmpty()) {
            setParentAndChild(lines.pop(), personAdam,adam, personList);
        }

        System.out.println(personAdam);
    }

    private static void setParentAndChild(String command, Person personAdam, String adam, List<String> personList) {
        String parent = command.split(" - ")[0];
        String child = command.split(" - ")[1];
        for (String s : personList) {
            if (s.contains(parent)) {
                parent = s;
                continue;
            }
            if (s.contains(child)) {
                child = s;
            }
        }
        if (adam.contains(parent)) {
            personAdam.setChildren(child);
        }
        if (adam.contains(child)) {
            personAdam.setParents(parent);
        }
    }
}
