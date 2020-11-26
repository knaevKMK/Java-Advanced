import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Voina {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        LinkedHashSet<Integer> playerOne = getPlayersCard();
        LinkedHashSet<Integer> playerTwo = getPlayersCard();

        for (int i = 0; i < 50; i++) {

            int playerOneFirstCard = getFirstCard(playerOne);
            int playerTwoFirstCard = getFirstCard(playerTwo);

            if (playerOneFirstCard > playerTwoFirstCard) {
                playerOne.addAll(Arrays.asList(playerOneFirstCard, playerTwoFirstCard));
            } else if (playerOneFirstCard < playerTwoFirstCard) {
                playerTwo.addAll(Arrays.asList(playerOneFirstCard, playerTwoFirstCard));
            }

            if (playerOne.isEmpty() || playerTwo.isEmpty()) {
                break;
            }
        }
        String result = "Draw!";
        if (playerOne.size() > playerTwo.size()) {
            result = "First player win!";
        } else if (playerOne.size() < playerTwo.size()) {
            result = "Second player win!";
        }
        System.out.println(result);

    }

    private static int getFirstCard(LinkedHashSet<Integer> player) {
        int card = player.iterator().next();
        player.remove(card);
        return card;
    }

    private static LinkedHashSet<Integer> getPlayersCard() {
        LinkedHashSet<Integer> player = new LinkedHashSet<>();
        int[] cards = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        for (int card : cards) {
            player.add(card);
        }
        return player;
    }
}