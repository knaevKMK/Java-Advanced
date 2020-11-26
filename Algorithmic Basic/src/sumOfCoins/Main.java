package sumOfCoins;

import java.util.*;
import java.util.stream.Collectors;

public class Main {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] elements = in.nextLine().substring(7).split(", ");
        int[] coins = new int[elements.length];
        for (int i = 0; i < coins.length; i++) {
            coins[i] = Integer.parseInt(elements[i]);
        }

        int targetSum = Integer.parseInt(in.nextLine().substring(5));

        Map<Integer, Integer> usedCoins = chooseCoins(coins, targetSum);

        if (targetSum == 0) {
            for (Map.Entry<Integer, Integer> usedCoin : usedCoins.entrySet()) {
                System.out.println(usedCoin.getKey() + " -> " + usedCoin.getValue());
            }
        } else {
            System.out.println("Error");
        }
    }

    public static Map<Integer, Integer> chooseCoins(int[] coins, int targetSum) {
        Map<Integer, Integer> usedCoins = new LinkedHashMap<>();
        if (targetSum > 0 || coins.length > 0) {

            int pcs = targetSum / coins[coins.length - 1];
            if (pcs > 0) {
                usedCoins.putIfAbsent(coins[coins.length - 1], pcs);
            }

            chooseCoins(Arrays.stream(coins).limit(coins.length - 1).toArray()
                    , targetSum % coins[coins.length - 1]);
        }
        if (coins.length == 0 && targetSum>0) {
            throw new IllegalArgumentException();
        }
        return usedCoins;

    }
}