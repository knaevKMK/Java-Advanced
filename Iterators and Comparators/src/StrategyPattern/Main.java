package StrategyPattern;

import com.sun.source.tree.Tree;

import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = Integer.parseInt(scanner.nextLine());
        TreeSet<Person> listName = new TreeSet<>(new PersonNameComparator());
        TreeSet<Person> listAge = new TreeSet<>( new PersonAgeComparator());
        for (int i = 0; i < n; i++) {
            Person person= new Person(scanner.nextLine().split("\\s+"));
            listName.add(person);
            listAge.add(person);
        }

       listName.forEach(System.out::println);
        listAge.forEach(System.out::println);
    }
}
