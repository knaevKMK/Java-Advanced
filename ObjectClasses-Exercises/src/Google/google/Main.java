package google;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Map<String, People> peopleList = new LinkedHashMap<>();
        setPeopleInList(peopleList);
        String read = scanner.nextLine();
        System.out.println(read + "\n" + peopleList.get(read));
    }

    private static void setPeopleInList(Map<String, People> peopleList) {
        String read;
        while (!"End".equals(read = scanner.nextLine())) {
            String[] token = read.split("\\s+", 3);

            String name = token[0];
            if (!peopleList.containsKey(name)) {
                People person = new People();
                peopleList.put(name, person);
            }
            People person = peopleList.get(name);
            switch (token[1]) {
                case "company":
                    person.setCompany(token[2]);
                    break;
                case "pokemon":
                    person.setPokemon(token[2]);
                    break;
                case "parents":
                    person.setParents(token[2]);
                    break;
                case "children":
                    person.setChildren(token[2]);
                    break;
                case "car":
                    person.setCar(token[2]);
                    break;
            }

            peopleList.put(name, person);
        }

    }
}
