package ComparingObjects;

import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        String read;
        while (!"END".equals(read = scanner.nextLine())) {
            list.add(new Person(read.split(" ")));
            ;
        }
        int n = Integer.parseInt(scanner.nextLine());
        Person person = list.get(n-1);
        int equal = 0;
        for (Person person1 : list) {
            if (person.compareTo(person1)==0) {
                equal++;
            }
        }
        if (equal==1){
            System.out.println("No matches");
            return ;
        }
        System.out.println(equal+" "+ (list.size() - equal)+ " "+ list.size());
    }
}
