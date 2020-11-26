package guild;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Guild {
    private String name;
    private int capacity;
    private List<Player> roster;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        if (this.capacity > roster.size()) {
            this.roster.add(player);
        }
    }

    public boolean removePlayer(String name) {
        return this.roster.removeIf(player -> player.getName().equals(name));
    }

    public void promotePlayer(String name) {
        for (Player player : roster) {
            if (player.getName().equals(name)) {
                player.setRank("Member");
                return;
            }
        }
    }

    public void demotePlayer(String name) {
        for (Player player : roster) {
            if (player.getName().equals(name)) {
                player.setRank("Trial");
            }
        }
    }

    public Player[] kickPlayersByClass(String clazz) {
        Player[] players =
                this.roster.stream().filter(player -> player.getClazz().equals(clazz)).toArray(Player[]::new);
        this.roster = this.roster.stream().filter(player -> !player.getClazz().equals(clazz)).collect(Collectors.toList());
        return players;
    }

    public int count() {
        return this.roster.size();
    }

    public String report() {
        StringBuilder print = new StringBuilder("Players in the guild: ")
                .append(this.name)
                .append(":")
                .append(System.lineSeparator());

        this.roster
                .forEach(player -> print.append(player.toString())
                        .append(System.lineSeparator()));
        return print.toString().trim();
    }
}
