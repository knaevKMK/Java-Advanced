package vetClinic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Clinic {
    private int capacity;
    private List<Pet> data;

    public Clinic(int capcacity) {
        this.capacity = capcacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet) {
        if (this.data.size() < capacity) {
            this.data.add(pet);
        }
    }

    public boolean remove(String name) {
        return this.data.removeIf(pet -> pet.getName().equals(name));
    }

    public Pet getPet(String name, String owner) {
        for (Pet pet : data) {
            if (pet.getName().equals(name) && pet.getOwner().equals(owner)) {
                return pet;
            }
        }
        return null;
    }

    public Pet getOldestPet() {
        return this.data.stream()
                .max(Comparator.comparing(Pet::getAge))
                .orElseThrow();
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder print = new StringBuilder("The clinic has the following patients:")
                .append(System.lineSeparator());
        for (Pet pet : this.data) {
            print.append(pet.getName()).append(" ").append(pet.getOwner()).append(System.lineSeparator());
        }

        return print.toString().trim();
    }
}
