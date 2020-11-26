package OpinionPoll;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> personList = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] token = scanner.nextLine().split("\\s+");
            int age = Integer.parseInt(token[1]);
            if (age > 30) {
                Person person = new Person(token[0], age);
                personList.add(person);
            }
        }

        personList.stream()
                .map(p->p.name+ " - "+ p.age)
                .sorted(String::compareTo)
                .forEach(System.out::println);
    }
}
