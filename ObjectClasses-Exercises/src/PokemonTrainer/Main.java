package PokemonTrainer;

import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Map<String, Trainer> trainerList = new LinkedHashMap<>();
        String read;
        while (!"Tournament".equals(read = scanner.nextLine())) {
            String[] token = read.split("\\s+");
            String name = token[0];
            String namePokemon = token[1];
            String element = token[2];
            int health = Integer.parseInt(token[3]);

            Pokemon pokemon = new Pokemon(namePokemon, element, health);
            Trainer trainer = new Trainer(pokemon);

            if (trainerList.containsKey(name)) {
                trainerList.get(name).getPokemonList().add(pokemon);
                continue;
            }
            trainerList.putIfAbsent(name, trainer);
        }

        while (!"End".equals(read = scanner.nextLine())) {
            for (Map.Entry<String, Trainer> trainer : trainerList.entrySet()) {
                boolean equal = false;
                for (Pokemon pokemon : trainer.getValue().getPokemonList()) {
                    if (pokemon.getElement().equals(read)) {
                        trainer.getValue().addBadgets();
                        equal = true;
                        break;
                    }
                }
                if (!equal) {
                    goesAndSetOtherPockemons(trainer.getValue().getPokemonList());
                }

            }
        }
        trainerList.entrySet()
                .stream().sorted((low, high) -> Integer.compare(high.getValue().getBadges(), low.getValue().getBadges()))
                .forEach(trainer -> System.out.println(trainer.getKey() + " " + trainer.getValue()));
    }

    private static void goesAndSetOtherPockemons(List<Pokemon> pokemonList) {
        for (int i = 0; i < pokemonList.size(); i++) {
            pokemonList.get(i).downHealth();
            if (pokemonList.get(i).getHealth() <= 0) {
                pokemonList.remove(pokemonList.get(i));
                i--;
            }
        }
    }
}
