package google;

import java.util.LinkedHashMap;
import java.util.Map;

public class People {
    Company company;
    Map<String, String> pokemon = new LinkedHashMap<>();
    Map<String, String> parents = new LinkedHashMap<>();
    Map<String, String> children = new LinkedHashMap<>();
    Car car;

    public void setCompany(String line) {
        this.company = new Company(line);
    }

    public void setPokemon(String line) {

        this.pokemon.put(line.split("\\s+")[0], line.split("\\s+")[1]);
    }

    public void setParents(String line) {
        this.parents.put(line.split("\\s+")[0], line.split("\\s+")[1]);
    }

    public void setChildren(String line) {
        this.children.put(line.split("\\s+")[0], line.split("\\s+")[1]);
    }

    public void setCar(String line) {
        this.car = new Car(line);
    }

    private String printMap(Map<String, String> temp) {
        StringBuilder print = new StringBuilder();
        temp.forEach((k, v) -> print.append(k).append(" ").append(v).append("\n"));
        return print.toString();
    }

    @Override
    public String toString() {
        String company = "";
        if (this.company != null) {
            company = String.valueOf(this.company);
        }
        String car = "";
        if (this.car != null) {
            car = String.valueOf(this.car);
        }

        return "Company:\n" + company
                + "Car:\n" + car
                + "Pokemon:\n" + printMap(this.pokemon)
                + "Parents:\n" + printMap(this.parents)
                + "Children:\n" + printMap(this.children);
    }
}
