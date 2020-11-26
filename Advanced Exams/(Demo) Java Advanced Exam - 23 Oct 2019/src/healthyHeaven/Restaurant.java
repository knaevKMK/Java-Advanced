package healthyHeaven;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Restaurant {
    private String name;
    private List<Salad> data;

    public Restaurant(String name) {
        this.name = name;
        this.data = new ArrayList<>();
    }

    public void add(Salad salad) {
        this.data.add(salad);
    }

    public boolean buy(String name) {
        return this.data.removeIf(salad -> salad.getName().equals(name));
    }

    public Salad getHealthiestSalad() {
        StringBuilder print = new StringBuilder();
        Salad salad = this.data.stream().min(Comparator.comparing(salat -> salat.getTotalCalories()))
                .orElse(null);
        print.append(salad.getName());
        return salad;
    }

    public String generateMenu() {
        StringBuilder print = new StringBuilder(this.name).append(" have ").append(this.data.size()).append(" salads:")
                .append(System.lineSeparator());
        this.data.forEach(s -> print.append(s).append(System.lineSeparator()));
        return print.toString().trim();
    }
}
