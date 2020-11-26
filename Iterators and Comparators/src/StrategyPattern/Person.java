package StrategyPattern;

import java.util.Comparator;

public class Person {
    private String name;
    private int age;

    public Person(String... s) {
        this.name = s[0];
        this.age = Integer.parseInt(s[1]);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return this.name + " " + this.age;
    }
}
