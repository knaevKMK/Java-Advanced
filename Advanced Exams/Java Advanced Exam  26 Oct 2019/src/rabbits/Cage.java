package rabbits;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Cage {
    private String name;
    private int capacity;
    private List<Rabbit> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Rabbit rabbit) {
        if (this.capacity > data.size())
            this.data.add(rabbit);
    }

    public boolean removeRabbit(String name) {
        return this.data.removeIf(rabbit -> rabbit.getName().equals(name));
    }

    public void removeSpecies(String species) {
        data.removeIf(rabbit -> rabbit.getSpecies().equals(species));
    }

    public Rabbit sellRabbit(String name) {
        for (Rabbit rabbit : data) {
            if (rabbit.getName().equals(name)) {
                rabbit.setAvailable(false);
                return rabbit;
            }
        }
        return null;
    }

    public List<Rabbit> sellRabbitBySpecies(String species) {
        Predicate<Rabbit> filter = rabbit -> rabbit.getSpecies().equals(species);
        data.stream()
                .filter(filter)
                .forEach(rabbit -> rabbit.setAvailable(false));
        return data.stream()
                .filter(filter)
                .collect(Collectors.toList());
    }

    public int count() {
        return data.size();
    }

    public String report() {
        StringBuilder print = new StringBuilder("Rabbits available at " + this.name + ":").append(System.lineSeparator());
        data.stream().filter(Rabbit::isAvailable)
                .forEach(rabbit -> print.append(rabbit).append(System.lineSeparator()));
        return print.toString();
    }
}
