package christmas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Bag {

    private String color;
    private int capacity;
    private List<Present> data;

    public Bag(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getColor() {
        return color;
    }

    public int getCapacity() {
        return capacity;
    }

    public int count() {
        return this.data.size();
    }

    public void add(Present present) {
        if (this.capacity > this.data.size()) {
            this.data.add(present);
        }
    }

    public boolean remove(String name) {
        return this.data.removeIf(present -> present.getName().equals(name));
    }

    public Present heaviestPresent() {
        return this.data.stream().max(Comparator.comparingDouble(Present::getWeight)).orElse(null);
    }

    public Present getPresent(String name) {
        return this.data.stream().filter(present -> present.getName().equals(name)).findFirst().orElse(null);
    }

    public String report() {
        String temp = getColor();
        temp = temp.substring(0, 1).toUpperCase() + temp.substring(1);
        StringBuilder print = new StringBuilder(temp + " bag contains:")
                .append(System.lineSeparator());
        this.data.forEach(present -> print.append(present).append(System.lineSeparator()));
        return print.toString().trim();
    }
}
