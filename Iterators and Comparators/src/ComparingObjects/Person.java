package ComparingObjects;

import java.util.Comparator;

public class Person implements Comparable<Person> {
    private String name;
    private int age;
    private String town;

    public Person(String...s) {
        this.name = s[0];
        this.age = Integer.parseInt(s[1]);
        this.town = s[2];
    }

    @Override
    public int compareTo(Person o) {
        int result = this.name.compareTo(o.name);
        if (result == 0) {
            result = Integer.compare(this.age, o.age);
        }
        if (result == 0) {
            result = this.town.compareTo(o.town);
        }
        return result;
    }
}
