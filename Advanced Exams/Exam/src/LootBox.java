import java.util.ArrayDeque;
import java.util.Scanner;

public class LootBox {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayDeque<Integer> first = new ArrayDeque<>();
    private static ArrayDeque<Integer> second = new ArrayDeque<>();
    private static int collect;

    public static void main(String[] args) {
        load();
        run();
    }

    private static void run() {
        while (true) {
            int one = first.poll();
            int two = second.pop();
            int sum = one + two;
            if (sum % 2 == 0) {
                collect += sum;
            } else {
                first.push(one);
                first.offer(two);
            }
            if (second.isEmpty()) {
                System.out.println("Second lootbox is empty");
                break;
            }
            if (first.isEmpty()) {
                System.out.println("First lootbox is empty");
                break;
            }
        }
        if (collect >= 100) {
            System.out.println("Your loot was epic! Value: " + collect);
        } else {
            System.out.println("Your loot was poor... Value: " + collect);
        }
    }

    private static void load() {
        String[] token = scanner.nextLine().split("\\s+");
        for (String s : token) {
            first.offer(Integer.parseInt(s));
        }
        token = scanner.nextLine().split("\\s+");
        for (String s : token) {
            second.push(Integer.parseInt(s));
        }
    }
}
