import java.util.*;

public class HandsOfCards {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Map<String, Set<String>> list = new LinkedHashMap<>();

        String read;
        while (!"JOKER".equals(read = scanner.nextLine())) {
            String name = read.substring(0, read.indexOf(":"));
            list.putIfAbsent(name, new LinkedHashSet<>());
            String[] cards = read.substring(read.indexOf(":") + 2).split(",\\s");
            list.get(name).addAll(Arrays.asList(cards));
        }

        list.forEach((k, v) -> System.out.println(k + ": " + getScore(v)));
    }

    public static int getScore(Set<String> cards) {
        int totalPower = 0;
        for (String card : cards) {
            int power = 0;
            String powerCard = card.substring(card.length() - 1);
            String forSwitch = card.replace(powerCard, "");
            switch (forSwitch) {
                case "J":
                    power = 11;
                    break;
                case "Q":
                    power = 12;
                    break;
                case "K":
                    power = 13;
                    break;
                case "A":
                    power = 14;
                    break;
                default:
                    power = Integer.parseInt(forSwitch);
            }
            switch (powerCard) {
                case "S":
                    power *= 4;
                    break;
                case "H":
                    power *= 3;
                    break;
                case "D":
                    power *= 2;
                    break;
                case "C":
                    break;
            }
            totalPower += power;
        }
        return totalPower;
    }
}
