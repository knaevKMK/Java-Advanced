package PokemonTrainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    //name, number of badges and a collection of pokemon
    //  private String name;
    private int badges;
    private List<Pokemon> pokemonList = new ArrayList<>();

    public Trainer(Pokemon pokemon) {
        //      this.name = name;
        this.badges = 0;
        this.pokemonList.add(pokemon);
    }

    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }

    public void addBadgets() {
        this.badges += 1;
    }

    public int getBadges() {
        return badges;
    }

    @Override
    public String toString() {
        return this.badges + " " + this.getPokemonList().size();
    }
}

